package shouty;

import java.util.*;

public class Shouty {

    Map<String, Integer> locations = new HashMap<String, Integer>();
    Map<String, List<String>> shouts = new HashMap<String, List<String>>();

    public void setLocation(String personName, int location) {
        locations.put(personName, location);
    }

    public int getDistance(String personName1, String personName2)
    {
        if (!locations.containsKey(personName1) || !locations.containsKey(personName2))
            return Integer.MAX_VALUE;

        return Math.abs(locations.get(personName1) - locations.get(personName2));
    }

    public void shout(String personName, String message) {
        for (String person: locations.keySet())
        {
            if (!personName.equals(person) && getDistance(personName, person)) {
                if (shouts.containsKey(person)) {
                    List<String> personShouts = shouts.get(person);
                    personShouts.add(message);
                    shouts.put(person, personShouts);
                }
            }
        }
    }

    public List<String> getMessagesHeardBy(String personName) {
        if (shouts.containsKey(personName))
            return shouts.get(personName);
        else
            return Collections.emptyList();
    }
}
