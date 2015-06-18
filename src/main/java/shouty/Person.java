package shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private double[] geoLocation;
    private List<String> receivedMessages = new ArrayList<String>();

    public void setGeoLocation(double[] geoLocation) {
        this.geoLocation = geoLocation;
    }

    public void receive(String message) {
        receivedMessages.add(message);
    }

    public List<String> getReceivedMessages() {
        return receivedMessages;
    }

    public double getLat() {
        return geoLocation[0];
    }

    public double getLon() {
        return geoLocation[1];
    }
}
