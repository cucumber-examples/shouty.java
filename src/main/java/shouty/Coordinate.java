package shouty;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }

    public int distanceFrom(Coordinate other) {
        int dx = x - other.x;
        int dy = y - other.y;

        return (int) Math.sqrt(dx * dx + dy * dy);
    }
}
