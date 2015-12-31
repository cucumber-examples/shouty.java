package shouty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainShouty implements Shouty {

    private Map<String, Person> people = new HashMap<String, Person>();

    @Override
    public void setLocation(String personName, int locationInMetres) {
        person(personName).setLocation(locationInMetres);
    }

    private Person person(String personName) {
        Person person = people.get(personName);
        if(person == null) {
            people.put(personName, person = new Person());
        }
        return person;
    }

    @Override
    public void shout(String shouterName, String message) {
        int shouterLocation = person(shouterName).getLocation();

        for (Person listener : people.values()) {
            int listenerLocation = listener.getLocation();
            int distance = Math.abs(listenerLocation - shouterLocation);

            if (distance <= 1000) {
                listener.hear(message);
            }
        }
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        return person(personName).getMessagesHeard();
    }

    @Override
    public void stop() {
        // no-op
    }
}
