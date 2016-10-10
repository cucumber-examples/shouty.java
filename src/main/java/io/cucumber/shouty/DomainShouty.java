package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainShouty implements ShoutyApi {
    public static final int RANGE = 1000;

    private final DeliveryMode deliveryMode;

    public enum DeliveryMode {
        PUSH, // The initial mode
        PULL  // The new mode, which allows messages to appear and disappear
    }

    private final Map<String, Person> people = new HashMap<>();
    private final List<Message> messages = new ArrayList<>();

    /**
     * @param deliveryMode feature toggle for push/pull mode
     */
    public DomainShouty(DeliveryMode deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    @Override
    public void setLocation(String personName, int locationInMetres) {
        person(personName).setLocation(locationInMetres);
    }

    private Person person(String personName) {
        Person person = people.get(personName);
        if (person == null) {
            people.put(personName, person = new Person());
        }
        return person;
    }

    @Override
    public void shout(String shouterName, String message) {
        int shouterLocation = person(shouterName).getLocation();

        switch(deliveryMode) {
            case PULL:
                storeMessage(message, shouterLocation);
                break;
            case PUSH:
                pushShouts(message, shouterLocation);
                break;
            default:
                throw new RuntimeException("Unsupported deliveryMode");
        }
    }

    private void storeMessage(String message, int shouterLocation) {
        messages.add(new Message(message, shouterLocation));
    }

    private void pushShouts(String message, int shouterLocation) {
        for (Person listener : people.values()) {
            int listenerLocation = listener.getLocation();
            int distance = Math.abs(listenerLocation - shouterLocation);

            if (distance <= RANGE) {
                listener.hear(message);
            }
        }
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        switch(deliveryMode) {
            case PULL:
                return getPulledMessages(personName);
            case PUSH:
                return getPushedMessages(personName);
            default:
                throw new RuntimeException("Unsupported deliveryMode");
        }
    }

    private List<String> getPulledMessages(String personName) {
        List<String> result = new ArrayList<>();
        Person listener = person(personName);
        for (Message message : messages) {
            int listenerLocation = listener.getLocation();
            int distance = Math.abs(listenerLocation - message.getLocation());

            if (distance <= RANGE) {
                result.add(message.getMessage());
            }
        }
        return result;
    }

    private List<String> getPushedMessages(String personName) {
        return person(personName).getMessagesHeard();
    }
}
