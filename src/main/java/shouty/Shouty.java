package shouty;

import java.util.HashSet;
import java.util.Set;

public class Shouty implements Network {
    Set<Person> people = new HashSet<Person>();

    public Person getPerson(String name) {
        final Person person = new Person(name, this);
        people.add(person);
        return person;
    }

    @Override
    public void broadcast(String shout) {
        for(Person person : people) {
            person.hear(shout);
        }

    }
}
