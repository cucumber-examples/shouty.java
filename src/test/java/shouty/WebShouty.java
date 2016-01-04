package shouty;

import java.util.List;

public class WebShouty implements Shouty {
    @Override
    public void setLocation(String personName, int locationInMetres) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void shout(String personName, String message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        throw new UnsupportedOperationException();
    }
}
