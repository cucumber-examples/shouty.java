package shouty;

import java.util.ArrayList;

public class Person {
    private final Location location;
    private ArrayList<String> messagesHeard = new ArrayList<String>();

    public Person(Location location) {
        this.location = location;
    }

    public ArrayList<String> messagesHeard() {
        return this.messagesHeard;
    }

    public void hear(String message) {
        this.messagesHeard.add(message);
    }

    public boolean isWithinRangeOf(Person shouter) {
        return this.location.withinRangeOf(shouter.getLocation());
    }

    public Location getLocation() {
        return location;
    }
}
