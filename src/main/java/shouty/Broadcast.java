package shouty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 11/5/15.
 */
public class Broadcast {

    private final List<Subscriber> listeners = new ArrayList<Subscriber>();

    public void subscribe(Subscriber subscriber) {
        listeners.add(subscriber);
    }

    public void transmit(String message) {
        for (Subscriber listener : listeners) {
            listener.hear(message);
        }
    }
}
