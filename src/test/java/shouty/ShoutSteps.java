package shouty;

import java.util.HashMap;
import java.util.Map;

public class ShoutSteps {
    private final Api api = new Api();

    private final Map<String, double[]> geoLocations = new HashMap<String, double[]>() {{
        put("Piccadilly Circus Station", new double[]{51.5101210, -0.1341683});
        put("Leicester Square Station", new double[]{51.5114242, -0.12873150});
        put("Heathrow Terminal 5", new double[]{51.4715066, -0.4879044});
    }};

    public ShoutSteps() {
    }
}
