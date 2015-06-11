package shouty;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Shouty shouty;
    private List<String> messagesHeard = new ArrayList<String>();

    public List<String> receivedMessages() {
        return messagesHeard;
    }

    public void shout(String message) {
        shouty.broadcast(message);
    }

    public void login(Shouty shouty) {
        this.shouty = shouty;
        shouty.addUser(this);
    }

    public void hear(String message) {
        this.messagesHeard.add(message);
    }
}
