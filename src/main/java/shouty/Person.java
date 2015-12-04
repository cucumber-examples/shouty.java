package shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private int location;
    private List<String> messagesHeard = new ArrayList<String>();

    public void hear(String message) {
        messagesHeard.add(message);
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public List<String> getMessagesHeard() {
        return messagesHeard;
    }
}
