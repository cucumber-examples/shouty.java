package shouty;

class Coordinate {
    private final int x;
    private final int y;

    Coordinate(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }

    int distanceFrom(Coordinate other) {
        return Math.abs(x - other.x);
    }
}
