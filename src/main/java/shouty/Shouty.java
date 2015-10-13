package shouty;

import java.util.HashMap;
import java.util.Map;

public class Shouty {

	private Map<String, Person> people = new HashMap<String, Person>();

	public Person findPerson(String username) {
		Person person = people.get(username);
		if (null == person) {
			person = new Person(this);
			people.put(username, person);
		}
		return person;
	}

	public void broadcast(String message) {
		for (Person person:people.values()) {
			person.hear(message);
		}
	}
}
