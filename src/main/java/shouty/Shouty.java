package shouty;

import java.util.ArrayList;
import java.util.Collection;

public class Shouty {

	private ArrayList<Shout> shoutsHeard = new ArrayList<Shout>();

	public Person getPersonByName(String name) {
		Person person = new Person(this, name);
		return person;
	}

	public Collection<Shout> getMyShouts() {
		return shoutsHeard;
	}

	public void sendShout(Shout shout) {
		shoutsHeard.add(shout);
	}
}
