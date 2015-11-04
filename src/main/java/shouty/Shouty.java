package shouty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shouty {
    private Map<String, Person> people = new HashMap<String, Person>();

    public void setLocation(String personName, int location) {
        findOrCreatePerson(personName).location = location;
    }

    public void shout(String personName, String message) {
        Person shouter = findOrCreatePerson(personName);
        for (Person listener : people.values()) {
            if (withinRange(listener, shouter)) {
                listener.messagesHeard.add(message);
            }
        }
    }

    private boolean withinRange(Person a, Person b) {
        return Math.abs(a.location - b.location) <= 1000;
    }

    public List<String> getMessagesHeardBy(String personName) {
        return findOrCreatePerson(personName).messagesHeard;
    }

    private Person findOrCreatePerson(String personName) {
        Person person = people.get(personName);
        if (person == null) {
            person = new Person();
            people.put(personName, person);
        }
        return person;
    }

    private class Person {
        public List<String> messagesHeard = new ArrayList<String>();
        public int location;
    }
}
