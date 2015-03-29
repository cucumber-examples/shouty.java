package shouty;

import java.util.ArrayList;
import java.util.List;

public class Shouty {
    private static final double MAX_DISTANCE_METRES = 1000;
    private final List<Person> people = new ArrayList<Person>();

    public void broadcast(String message, double[] shouterLocation) {
        for (Person person : people) {
            double distance = distanceBetween(
                    person.getLocation(), shouterLocation);
            if(distance < MAX_DISTANCE_METRES) {
                person.hear(message);
            }
        }
    }

    private double distanceBetween(double[] loc1, double[] loc2) {
        return 0;
    }

    public void subscribe(Person person) {
        people.add(person);
    }
}
