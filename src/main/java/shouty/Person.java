package shouty;

import java.util.ArrayList;
import java.util.List;

import static shouty.Haversine.haversine;

class Person {
    private final double[] geoLocation;
    private List<String> messagesHeard = new ArrayList<String>();

    public Person(double[] geoLocation) {
        this.geoLocation = geoLocation;
    }

    public List<String> getMessagesHeard() {
        return messagesHeard;
    }

    public void hear(String message) {
        messagesHeard.add(message);
    }

    public boolean isInRange(Person shouter) {
        double distanceInMiles = haversine(
                geoLocation[0],
                geoLocation[1],
                shouter.geoLocation[0],
                shouter.geoLocation[1]
        );
        return distanceInMiles < 1;
    }
}
