package shouty;

import java.util.ArrayList;

public class Shouty {
    private ArrayList<Person> registeredUsers = new ArrayList<Person>();

    public void register(Person person) {
        this.registeredUsers.add(person);
    }

    public void broadcast(String message, Person shouter) {
        for(Person listener : registeredUsers) {
            if (listener.isWithinRangeOf(shouter))
                listener.hear(message);
        }
    }
}
