package shouty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shouty {
    private Map<String, Person> people = new HashMap();

    public void setLocation(String personName, int location) {
        getPersonCalled(personName).setLocation(location);
    }

    private Person getPersonCalled(String personName) {
        Person person = people.get(personName);

        if (person == null) {
            person = new Person();
            people.put(personName, person);
        }

        return person;
    }

    public void shout(String personName, String message) {
        for (Person person : people.values()) {
            person.hear(message);
        }
    }

    public List<String> getMessagesHeardBy(String personName) {
        Person person = getPersonCalled(personName);
        return person.getMessagesHeard();
    }
}
