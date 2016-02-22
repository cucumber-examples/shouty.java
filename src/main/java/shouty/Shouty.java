package shouty;

import java.util.*;

public class Shouty {
    private final int MESSAGE_RANGE = 1000;
    private Map<String, Coordinate> locations = new HashMap<String, Coordinate>();
    private Map<String, String> messages = new HashMap<String, String>();

    public void setLocation(String person, Coordinate location) {
      locations.put(person, location);
    }

    public void shout(String person, String message) {
      messages.put(person, message);
    }

    public List<String> getMessagesHeardBy(String listener) {
        List<String> messagesHeard = new ArrayList<String>();

        for (Map.Entry<String, String> entry : messages.entrySet()) {
            messagesHeard.add(entry.getValue());
        }

        return messagesHeard;
    }
}
