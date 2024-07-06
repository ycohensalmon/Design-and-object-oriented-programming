import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BitArray implements Clusterable<BitArray> {
	private ArrayList<Boolean> bits;

	// Constructeur qui prend une chaîne de caractères (ex: "true,false,true")
	public BitArray(String str) {
		this.bits = Stream.of(str.split(","))
				.map(Boolean::parseBoolean)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	// Constructeur qui prend un tableau de booléens
	public BitArray(boolean[] bits) {
		this.bits = IntStream.range(0, bits.length)
				.mapToObj(i -> bits[i])
				.collect(Collectors.toCollection(ArrayList::new));
	}

	// Méthode pour calculer la distance de Hamming entre deux tableaux de bits
	@Override
	public double distance(BitArray other) {
		return IntStream.range(0, Math.max(this.bits.size(), other.bits.size()))
				.filter(i -> (i < this.bits.size() ? this.bits.get(i) : false) != (i < other.bits.size() ? other.bits.get(i) : false))
				.count();
	}

	// Méthode pour lire un ensemble de BitArray à partir d'un fichier
	// Retient uniquement les bitarrays de longueur maximale
	public static Set<BitArray> readClusterableSet(String path) throws IOException {
		var lines = Files.lines(Paths.get(path)).collect(Collectors.toList());
		int maxLength = lines.stream()
				.mapToInt(line -> line.split(",").length)
				.max()
				.orElse(0);

		return lines.stream()
				.filter(line -> line.split(",").length == maxLength)
				.map(BitArray::new)
				.collect(Collectors.toSet());
	}

	@Override
	public String toString() {
		return bits.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BitArray bitArray = (BitArray) o;
		return bits.equals(bitArray.bits);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bits);
	}
}
