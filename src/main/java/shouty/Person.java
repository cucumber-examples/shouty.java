package shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final Shouty shouty;
    private List<String> messagesHeard = new ArrayList<String>();
    private double[] location;

    public Person(Shouty shouty) {
        this.shouty = shouty;
        shouty.subscribe(this);
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

    public void shout(String message) {
        shouty.broadcast(message, location);
    }

    public List<String> getMessagesHeard() {
        return messagesHeard;
    }

    public void hear(String message) {
        messagesHeard.add(message);
    }

    public double[] getLocation() {
        return location;
    }
}
