package shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private int location;
    private List<String> messagesHeard = new ArrayList();

    public void setLocation(int location) {
        this.location = location;
    }

    public void hear(String message) {
        messagesHeard.add(message);
    }

    public List<String> getMessagesHeard() {
        return messagesHeard;
    }
}
