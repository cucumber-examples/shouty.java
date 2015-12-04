package shouty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shouty {

    private Map<String, Person> people = new HashMap<String, Person>();

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

    public void shout(String personName, String message) {
        for (Person person : people.values()) {
            person.hear(message);
        }
    }

    public List<String> getMessagesHeardBy(String personName) {
        return person(personName).getMessagesHeard();
    }
}
