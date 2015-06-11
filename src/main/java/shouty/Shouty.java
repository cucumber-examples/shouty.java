package shouty;

import java.util.ArrayList;
import java.util.List;

public class Shouty {
    private List<User> users = new ArrayList<User>();

    public void broadcast(String message) {
        for(User user : users) {
            user.hear(message);
        }
    }

    public void addUser(User user) {
        users.add(user);
    }
}
