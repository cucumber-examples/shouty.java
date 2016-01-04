package shouty;

import java.util.List;

public interface Shouty {
    void setLocation(String personName, int locationInMetres);

    void shout(String personName, String message);

    List<String> getMessagesHeardBy(String personName);
}
