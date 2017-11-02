package shouty;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }

    public int distanceFrom(Coordinate other) {
        double xDistance = x - other.x;
        double yDistance = y - other.y;
        // TODO: actually caluculate distance. I think we need to use pythagoras' theorem?
        return (int) Math.hypot(xDistance, yDistance);
    }
}
