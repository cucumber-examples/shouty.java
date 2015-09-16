package shouty;

import cucumber.api.java8.En;

import java.util.HashMap;
import java.util.Map;

public class ShoutSteps implements En {
    private final Api api = new Api();

    private final Map<String, double[]> geoLocations = new HashMap<String, double[]>() {{
        put("NCR Edinburgh", new double[]{55.93543, -3.1802811});
        put("Old Bell Inn", new double[]{55.93543, -3.1802811});
        put("Waverly", new double[]{55.9439029, -3.1953632});
    }};

    public ShoutSteps() {
    }
}
