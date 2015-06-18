package shouty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static shouty.Haversine.haversine;

public class ShoutyDomain {
    private static final double RANGE_IN_METERS = 1000;
    private Map<String, Person> people = new HashMap<String, Person>();

    public void personIsIn(String personName, double[] geoLocation) {
        Person person = findPerson(personName);
        if (person == null) {
            person = new Person();
            people.put(personName, person);
        }
        person.setGeoLocation(geoLocation);
    }

    private Person findPerson(String personName) {
        return people.get(personName);
    }

    public void sendShout(String personName, String message) {
        Person shouter = findPerson(personName);
        for (Person listener : people.values()) {
            if (isWithinRange(shouter, listener)) {
                listener.receive(message);
            }
        }
    }

    private boolean isWithinRange(Person shouter, Person listener) {
        double distanceInMeters = haversine(
                shouter.getLat(), shouter.getLon(),
                listener.getLat(), listener.getLon()
        );
        return distanceInMeters <= RANGE_IN_METERS;
    }

    public List<String> getReceivedMessages(String personName) {
        return findPerson(personName).getReceivedMessages();
    }
}
