package shouty;

public class PersonLocation {
	public String name;
	public int x;
	public int y;
	
	public Coordinate getCoordinate() {
		return new Coordinate(x,y);
	}
}
