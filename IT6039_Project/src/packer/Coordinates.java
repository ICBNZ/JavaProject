package packer;

/**
 *
 * @author I.M.Bad
 */
public class Coordinates {

    private final double x;
    private final double y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    /**
     * Euclidean Distance: Calculates euclidean distance between co-ordinates
     * @param other Co-ordinates
     * @return distance
     */
    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff),0.5);
        return dist;
    }


    /**
     * Manhattan Distance: Calculates manhattan distance between co-ordinates
     * @param other
     * @return distance
     */
    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }


    /**
     * Company Distance To: Calculates the euclidean and manhattan distances between co-ordinates
     * and finds average distance from Customer's address to Depot
     * @param other Depot co-ordinates
     * @return average of both calculated distances +1 as per proprietary distance metric
     */
    public double companyDistanceTo(Coordinates other) {
        double dist1 = euclideanDistanceTo(other);
        double dist2 = manhattanDistanceTo(other);

        // get average of both distances
        return ((dist1 + dist2)/2)+1;
    }

}