package shouty;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }

    public int distanceFrom(Coordinate other) {
    		int a = Math.abs(other.x - x);
    		int b = Math.abs(other.y - y);
        return (int) Math.hypot(a, b);
    }
}
