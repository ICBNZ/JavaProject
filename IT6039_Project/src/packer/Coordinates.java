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

    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff),0.5);
        return dist;
    }

    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }

    public double companyDistanceTo(Coordinates other) {
        double dist1 = euclideanDistanceTo(other);
        double dist2 = manhattanDistanceTo(other);

        // get average of both distances
        return ((dist1 + dist2)/2)+1;
    }

}