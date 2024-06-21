import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoDPoint implements Clusterable<TwoDPoint>{
	double x;
	double y;
	public TwoDPoint(String str){
		String[] parts = str.split(",");
		this.x = Double.parseDouble(parts[0]);
		this.y = Double.parseDouble(parts[1]);
	}
	public TwoDPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public double distance(TwoDPoint other) {
		return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
	}

	public static Set<TwoDPoint> readClusterableSet(String path) throws IOException{
		List<String> lines = Files.readAllLines(Paths.get(path));
		return lines.stream()
				.map(TwoDPoint::new)
				.collect(Collectors.toSet());
	}

	@Override
	public String toString() {
		return x + "," + y;
	}

	@Override
	public boolean equals(Object other) {
		TwoDPoint otherP = (TwoDPoint) other;
		return (otherP.x == x && otherP.y == y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
