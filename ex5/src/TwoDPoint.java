import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoDPoint implements Clusterable<TwoDPoint> {
	double x;
	double y;

	// Constructeur qui prend une chaîne de caractères (ex: "3.0,4.0")
	public TwoDPoint(String str) {
		String[] parts = str.split(",");
		this.x = Double.parseDouble(parts[0]);
		this.y = Double.parseDouble(parts[1]);
	}

	// Constructeur qui prend deux doubles
	public TwoDPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// Méthode pour calculer la distance euclidienne entre deux points 2D
	@Override
	public double distance(TwoDPoint other) {
		return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
	}

	// Méthode pour lire un ensemble de points 2D à partir d'un fichier
	public static Set<TwoDPoint> readClusterableSet(String path) throws IOException {
		return Files.lines(Paths.get(path))
				.map(TwoDPoint::new)
				.collect(Collectors.toSet());
	}

	@Override
	public String toString() {
		return x + "," + y;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (other == null || getClass() != other.getClass()) return false;
		TwoDPoint otherP = (TwoDPoint) other;
		return Double.compare(otherP.x, x) == 0 && Double.compare(otherP.y, y) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
