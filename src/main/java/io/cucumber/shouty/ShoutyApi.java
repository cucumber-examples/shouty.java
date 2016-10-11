package io.cucumber.shouty;

import java.util.List;

public interface ShoutyApi {
    void setLocation(String personName, int locationInMetres);

    int getLocation(String personName);

    void shout(String shouterName, String message);

    List<String> getMessagesHeardBy(String personName);

    void reset();
}
