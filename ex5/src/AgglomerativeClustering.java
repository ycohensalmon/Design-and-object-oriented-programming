import java.util.*;
import java.util.stream.Collectors;

public class AgglomerativeClustering<T extends Clusterable<T>> implements Clustering<T> {
	double threshold;

	public AgglomerativeClustering(double threshold) {
		this.threshold = threshold;
	}

	@Override
	public Set<Set<T>> clusterSet(Set<T> elements) {
		// Initialisation des clusters
		Set<Set<T>> clusters = elements.stream()
				.map(Collections::singleton)
				.collect(Collectors.toSet());

		while (clusters.size() > 1) {
			// Trouver les deux clusters les plus proches
			var closestPair = findClosestClusters(clusters);

			// Si la distance minimale est supérieure au seuil, arrêter l'algorithme
			if (closestPair.getValue() > threshold) {
				return clusters;
			}

			// Fusionner les deux clusters les plus proches
			clusters = clusters.stream()
					.filter(c -> !c.equals(closestPair.getKey().getKey()) && !c.equals(closestPair.getKey().getValue()))
					.collect(Collectors.toSet());
			Set<T> mergedCluster = new HashSet<>(closestPair.getKey().getKey());
			mergedCluster.addAll(closestPair.getKey().getValue());
			clusters.add(mergedCluster);
		}

		return clusters;
	}

	private AbstractMap.SimpleEntry<Map.Entry<Set<T>, Set<T>>, Double> findClosestClusters(Set<Set<T>> clusters) {
		return clusters.stream()
				.flatMap(c1 -> clusters.stream()
						.filter(c2 -> !c1.equals(c2))
						.map(c2 -> new AbstractMap.SimpleEntry<>(
								Map.entry(c1, c2), clusterDistance(c1, c2))))
				.min(Map.Entry.comparingByValue())
				.orElseThrow();
	}

	private double clusterDistance(Set<T> c1, Set<T> c2) {
		return c1.stream()
				.flatMap(i1 -> c2.stream().map(i1::distance))
				.min(Double::compare)
				.orElse(Double.MAX_VALUE);
	}
}
