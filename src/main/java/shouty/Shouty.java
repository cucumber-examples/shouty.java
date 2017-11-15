package shouty;

import java.util.HashMap;
import java.util.Map;

public class Shouty {
    private static final int MESSAGE_RANGE = 1000;
    private Map<String, Coordinate> locations = new HashMap<String, Coordinate>();
    private Map<String, String> shouts = new HashMap<String, String>();

    public void setLocation(String person, Coordinate location) {
        locations.put(person, location);
    }

    public void shout(String shouter, String shout) {
        shouts.put(shouter, shout);
    }

    public Map<String, String> getShoutHeardBy(String listener) {
        HashMap<String, String> shoutsHeard = new HashMap<String, String>();

        for (Map.Entry<String, String> entry : shouts.entrySet()) {
            String shouter = entry.getKey();
            String personsShouts = entry.getValue();
            int distance = locations.get(listener).distanceFrom(locations.get(shouter));
            if (distance < MESSAGE_RANGE)
                shoutsHeard.put(shouter, personsShouts);
        }

        return shoutsHeard;
    }
}