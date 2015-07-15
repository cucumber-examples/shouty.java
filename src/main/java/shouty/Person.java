package shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<String> heardMessages = new ArrayList<String>();

    public Person(String name) {
    }

    public List<String> getHeardMessages() {
        return heardMessages;
    }

    public void hear(String message) {
        heardMessages.add(message);
    }
}
