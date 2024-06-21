import java.util.*;
import java.util.stream.Collectors;


public class AgglomerativeClustering <T extends Clusterable<T>> implements Clustering<T>{
	double threshold;
	public AgglomerativeClustering(double threshold) {
		this.threshold = threshold;
	}
	public Set<Set<T>> clusterSet(Set<T> elements) {
		Set<Set<T>> clusters = elements.stream()
				.map(e -> {
					Set<T> singleton = new HashSet<>();
					singleton.add(e);
					return singleton;
				})
				.collect(Collectors.toSet());

		while (clusters.size() > 1) {
			List<AbstractMap.SimpleEntry<Set<T>, Set<T>>> closestPairs = findClosestPairs(clusters);
			AbstractMap.SimpleEntry<Set<T>, Set<T>> closestPair = closestPairs.stream()
					.min(Comparator.comparingDouble(pair -> clusterDistance(pair.getKey(), pair.getValue())))
					.orElseThrow();

			double minDistance = clusterDistance(closestPair.getKey(), closestPair.getValue());
			if (minDistance > threshold) break;

			clusters.remove(closestPair.getKey());
			clusters.remove(closestPair.getValue());

			Set<T> union = new HashSet<>(closestPair.getKey());
			union.addAll(closestPair.getValue());
			clusters.add(union);
		}

		return clusters;
	}

	private double clusterDistance(Set<T> c1, Set<T> c2) {
		return c1.stream()
				.flatMap(e1 -> c2.stream().map(e2 -> e1.distance(e2)))
				.min(Double::compare)
				.orElse(Double.MAX_VALUE);
	}

	private List<AbstractMap.SimpleEntry<Set<T>, Set<T>>> findClosestPairs(Set<Set<T>> clusters) {
		List<Set<T>> clusterList = new ArrayList<>(clusters);
		return clusterList.stream()
				.flatMap(c1 -> clusterList.stream().filter(c2 -> c1 != c2)
						.map(c2 -> new AbstractMap.SimpleEntry<>(c1, c2)))
				.collect(Collectors.toList());
	}
}
