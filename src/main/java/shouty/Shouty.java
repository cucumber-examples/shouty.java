package shouty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shouty {
    private Map<String, Person> people = new HashMap<String, Person>();

    public void personIsIn(String personName, double[] geoLocation) {
        people.put(personName, new Person(geoLocation));
    }

    public void shout(String shouterName, String message) {
        Person shouter = people.get(shouterName);
        for (Person recipient : people.values()) {
            if(recipient.isInRange(shouter)) {
                recipient.hear(message);
            }
        }
    }

    public List<String> getMessagesHeardBy(String personName) {
        Person person = people.get(personName);
        return person.getMessagesHeard();
    }

}
