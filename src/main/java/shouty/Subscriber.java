package shouty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 11/5/15.
 */
public class Subscriber {
    private final Broadcast broadcast;
    private final List<String> messagesHeard = new ArrayList<String>();


    public Subscriber(Broadcast broadcast) {
        this.broadcast = broadcast;
        broadcast.subscribe(this);
    }

    public void shout(String message) {
        broadcast.transmit(message);
    }

    public void hear(String message) {
        messagesHeard.add(message);
    }

    public List<String> getMessagesHeard() {
        return messagesHeard;
    }
}
