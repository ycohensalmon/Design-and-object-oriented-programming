public class Plane implements Movable, Comparable{
    public static final int HEIGHT_LIMIT = 1500;
    int licenceNumber;
    Location source, destination;
    int maximalHeight;

    public Plane(int id, Location src, Location dst, int maxHeight) {
        licenceNumber = id;
        source = src;
        destination = dst;
        maximalHeight = maxHeight;
    }

    @Override
	public String toString() {
		return String.format("licence = %d, source = %s, destination = %s, maxHeight = %d",
				licenceNumber, source, destination, maximalHeight);
	}
	
    @Override
    public String getType() {
        return "Plane";
    }

    @Override
    public int getId() {
        return licenceNumber;
    }

    @Override
    public Location getSource() {
        return source;
    }

    @Override
    public Location getDestination() {
        return destination;
    }

    @Override
    public String getCurrentLocation() {
        return String.format("%s %d going from %s to %s. Currently in %s",
                getType(), licenceNumber, getSource(), getDestination(), getSource());
    }

    @Override
    public void move() {
        Location temp_dest = destination;
        destination = source;
        source = temp_dest;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.maximalHeight, ((Plane) o).maximalHeight);
    }

}
