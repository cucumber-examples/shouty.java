package shouty;

import shouty.Message;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class Person {
    private Network network;
    public Person(String name, Network network) {
        this.network = network;
    }

    private final ArrayList<String> messages = new ArrayList<String>();

    public List<String> getReceivedMessages() {
        return messages;
    }

    public void shout(String shout) {
        network.broadcast(shout);
    }

    public void hear(String shout) {
        messages.add(shout);
    }
}
