public class Train implements Comparable, Movable{
    public static final int PASSENGER_LIMIT = 500;
    public static final int STATION_LIMIT = 5;
    int licenceNumber;
    Location source, destination;
    int numberOfStations;
    int currentStation;
    int maximalPassenger;

    public Train(int id, Location src, Location dst, int numOfStations, int maxPassengers) {
        licenceNumber = id;
        source = src;
        destination = dst;
        numberOfStations = numOfStations;
        currentStation = 0;
        maximalPassenger = maxPassengers;
    }

	@Override
	public String toString() {
		return String.format("licence = %d, source = %s, destination = %s, station = %d, maxPassengers = %d",
				licenceNumber, source, destination, currentStation, maximalPassenger);
    }

    @Override
    public String getType() {
        return "Train";
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
        String msg = String.format("%s %d going from %s to %s. Currently in ",
                getType(), licenceNumber, getSource(), getDestination());

        if (currentStation == 0)
            return msg + getSource().toString();
        else
            return msg + String.format("station %d between %s and %s.",
                    currentStation, getSource(), getDestination());
    }

    @Override
    public void move() {
        if (currentStation < numberOfStations - 1) {
           currentStation++;
        }
        else
        {
            currentStation = 0;
            Location temp_dest = destination;
            destination = source;
            source = temp_dest;
        }


    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.maximalPassenger, ((Train) o).maximalPassenger);
    }
}
