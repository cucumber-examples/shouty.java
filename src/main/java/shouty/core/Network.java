package shouty.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Network {
    private final List<Person> listeners = new ArrayList<Person>();
    private final int range;

    public Network(int range) {
        this.range = range;
    }

    public void subscribe(Person person) {
        listeners.add(person);
    }

    public void broadcast(String message, Person shouter) {
        for (Person listener : listenersWithinRangeOf(shouter)) {
            listener.hear(message);
        }
    }

    private List<Person> listenersWithinRangeOf(Person shouter) {
        return listeners.stream().filter(listener ->
                        Math.abs(listener.getLocation() - shouter.getLocation()) <= range
        ).collect(Collectors.toList());
    }
}
