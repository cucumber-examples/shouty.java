package shouty;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Person> people = new ArrayList<Person>();

    public void register(Person person, int location) {
        people.add(person);
    }

    public void broadcast(Person shouter, String message) {
        for(Person listener: people) {
            listener.hear(message);
        }
    }
}
