package shouty;

import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LocationSteps {

    @Autowired
    private Shouty shouty;

    @Given("^(\\w+) is at (\\d+), (\\d+)$")
    public void lucy_is_at(String person, int xCoord, int yCoord) throws Throwable {
        shouty.setLocation(person, new Coordinate(xCoord, yCoord));
    }

    @Given("^people are located at$")
    public void peopleAreLocatedAt(List<Whereabout> whereabouts) throws Exception {
        for (Whereabout whereabout : whereabouts) {
            shouty.setLocation(whereabout.name, new Coordinate(whereabout.x, whereabout.y));
        }
    }
}
