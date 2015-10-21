package shouty;

import java.util.ArrayList;
import java.util.Collection;

public class Person {

	private Shouty server;

	public Person(Shouty server, String name) {
		this.server = server;
	}

	public void sendShout(Shout shout) {
		server.sendShout(shout);
	}

	public Collection<Shout> getMyShouts() {
		return server.getMyShouts();
	}

}
