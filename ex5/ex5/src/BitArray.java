import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class BitArray implements Clusterable<BitArray>{
	private ArrayList<Boolean> bits;

	public BitArray(String str){
		this.bits = str.chars()
				.mapToObj(c -> c == '1')
				.collect(Collectors.toCollection(ArrayList::new));
	}
	public BitArray(boolean[] bits) {
		this.bits = new ArrayList<>();
		for (boolean b : bits) {
			this.bits.add(b);
		}
	}

	@Override
	public double distance(BitArray other) {
		int maxLength = Math.max(this.bits.size(), other.bits.size());
		return (int) IntStream.range(0, maxLength)
				.mapToObj(i -> {
					boolean bit1 = i < this.bits.size() ? this.bits.get(i) : false;
					boolean bit2 = i < other.bits.size() ? other.bits.get(i) : false;
					return bit1 != bit2;
				})
				.filter(different -> different)
				.count();
	}

	public static Set<BitArray> readClusterableSet(String path) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(path));
		int maxLength = lines.stream().mapToInt(String::length).max().orElse(0);

		return lines.stream()
				.filter(line -> line.length() == maxLength)
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
