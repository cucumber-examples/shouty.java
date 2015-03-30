package shouty;

import java.util.ArrayList;
import java.util.List;

public class Shouty {
    private static final double MAX_DISTANCE_METRES = 5000;
    private final List<Person> people = new ArrayList<Person>();

    public void broadcast(String message, double[] shouterLocation) {
        for (Person person : people) {
            double metresApart = distanceInMetres(person.getLocation(), shouterLocation);
            if(metresApart < MAX_DISTANCE_METRES) {
                person.hear(message);
            }
        }
    }

    public void subscribe(Person person) {
        people.add(person);
    }

    private double distanceInMetres(double[] loc1, double[] loc2) {
        return distanceInMetres(loc1[0], loc1[1], loc2[0], loc2[1]);
    }

    private double distanceInMetres(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371000; //metres
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = earthRadius * c;

        return dist;
    }

}
