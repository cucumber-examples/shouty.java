package shouty.features;

import shouty.core.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ShoutSupport {
    private final Map<String, Person> people = new HashMap<String, Person>();
    protected final Map<String, List<String>> messagesShoutedBy = new HashMap<String, List<String>>();

    public abstract void seanShout(String message);

    public abstract List<String> getMessagesHeardBy(String name);

    public Map<String, Person> getPeople() {
        return people;
    }

    public List<String> getMessagesShoutedBy(String name) {
        return messagesShoutedBy.get(name);
    }

    protected void rememberMessageShoutedBy(String message, String personName) {
        if (!messagesShoutedBy.containsKey(personName)) {
            messagesShoutedBy.put(personName, new ArrayList<String>());
        }
        messagesShoutedBy.get(personName).add(message);
    }
}
