package shouty;

import java.util.List;

public class SeleniumShouty implements Shouty {
    @Override
    public void setLocation(String personName, int locationInMetres) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void shout(String shouterName, String message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        throw new UnsupportedOperationException();
    }
}
