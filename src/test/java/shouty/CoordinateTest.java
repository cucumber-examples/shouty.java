package shouty;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CoordinateTest {
    
    @Test
    public void itCalculatesTheDistanceFromItself() {
        Coordinate a = new Coordinate(0, 0);
        assertEquals(0, a.distanceFrom(a));
    }


    @Test
    public void it_calculates_the_distance_from_another_coordinate_along_x_axis() {
        Coordinate a = new Coordinate(0, 0);
        Coordinate b = new Coordinate(1000, 0);
        assertEquals(1000, a.distanceFrom(b));
    }
}
