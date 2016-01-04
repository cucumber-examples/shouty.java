package shouty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainShouty implements Shouty {
    private Map<String, Person> people = new HashMap();

    @Override
    public void setLocation(String personName, int locationInMetres) {
        personCalled(personName).setLocation(locationInMetres);
    }

    @Override
    public void shout(String personName, String message) {
        int shouterLocation = personCalled(personName).getLocation();

        for (Person person : people.values()) {
            int listenerLocation = person.getLocation();
            int distance = Math.abs(listenerLocation - shouterLocation);

            if (distance <= 1000) {
                person.hear(message);
            }
        }
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        return personCalled(personName).getMessagesHeard();
    }

    @Override
    public void stop() {
        // no-op
    }

    private Person personCalled(String personName) {
        Person person = people.get(personName);

        if (person == null) {
            people.put(personName, person = new Person());
        }

        return person;
    }
}
