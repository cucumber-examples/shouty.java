package shouty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shouty {
    private Map<String, Integer> locations = new HashMap<String, Integer>();
    private String shouterName;
    private String shouterMessage;

    public void setLocation(String personName, int location) {
        locations.put(personName, location);
    }

    public void shout(String personName, String message) {
        shouterName = personName;
        shouterMessage = message;
    }

    private boolean withinRange(String a, String b) {
        return Math.abs(locations.get(a) - locations.get(b)) <= 1000;
    }

    public List<String> getMessagesHeardBy(String listenerName) {
        List<String> messagesHeard = new ArrayList<String>();
        Integer shoutLocation = locations.get(shouterName);
        Integer listenerLocation = locations.get(listenerName);

        if (withinRange(listenerName, shouterName)) {
            messagesHeard.add(shouterMessage);
        }

        return messagesHeard;
    }
}
