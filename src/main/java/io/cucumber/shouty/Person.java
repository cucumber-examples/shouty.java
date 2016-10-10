package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

class Person {

    private int location;
    private List<String> messagesHeard = new ArrayList<String>();

    void hear(String message) {
        messagesHeard.add(message);
    }

    void setLocation(int location) {
        this.location = location;
    }

    List<String> getMessagesHeard() {
        return messagesHeard;
    }

    int getLocation() {
        return location;
    }
}
