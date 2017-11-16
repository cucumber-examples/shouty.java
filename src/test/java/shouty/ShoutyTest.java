package shouty;

import org.junit.Test;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;

public class ShoutyTest {
    @Test
    public void shouter_should_not_hear_themselves() {
        Shouty shouty = new Shouty();

        Coordinate location = new Coordinate(0, 0);
        shouty.setLocation("Lucy", location);

        shouty.shout("Lucy", "message");

        assertEquals(emptyMap(), shouty.getShoutHeardBy("Lucy"));
    }
}
