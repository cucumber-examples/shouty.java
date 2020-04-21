package shouty;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.Console;

public class SmokeAndMirrors {
    private final ShoutyServiceWrapper shouty;

    public SmokeAndMirrors(ShoutyServiceWrapper shouty_){
        shouty = shouty_;
    }

    @Before
    public void setupExampleData(Scenario scenario) {
        switch (scenario.getName()) {
            case "In range shout is heard":
            case "Range calculated using specified location of business shout":
                shouty.chooseStubbedData("0");
                break;
            case "Out of range shout is not heard":
                shouty.chooseStubbedData("1");
                break;
            default:
                throw new RuntimeException("Unrecognised scenario name");
        }
    }
}
