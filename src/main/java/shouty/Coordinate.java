package shouty;

public class Coordinate {
  private int x;
  private int y;

  public Coordinate(int xCoord, int yCoord){
    x = xCoord;
    y = yCoord;
  }

  public int distanceFrom(Coordinate other){
    int xDiff = x - other.x;
    int yDiff = y - other.y;

    return (int) Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
  }
}
