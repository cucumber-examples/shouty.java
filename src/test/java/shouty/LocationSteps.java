package shouty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Given;

public class LocationSteps {
	@Autowired
    private Shouty shouty;

    @Given("^(Lucy|Sean|Oscar) is at (\\d*), (\\d+)$")
    public void person_is_at(String personName, int xCoord, int yCoord) throws Throwable {
        shouty.setLocation(personName, new Coordinate(xCoord, yCoord));
    }
    
    @Given("^people are located at$")
    public void people_are_located_at(List<PersonLocation> locations) throws Exception {
    		for(PersonLocation location : locations) {
    			shouty.setLocation(location.name, location.getCoordinate());
    		}
    }

}
