package shouty;

import java.util.ArrayList;
import java.util.List;

public class Shouty {

	private int range = 0;

	public void setMaxRange(int distance) {
		this.range  = distance;
	}
	// This is where we'll write the code of our Shouty app

	public void setUserLocation(String name, int location) {
		User user = User.findUserByName(name);
		user.setLocation(location);
	}

	public String[] getMessagesFor(String name) {
		return User.findUserByName(name).getMessages();
	}

	public void send(String name, String message) {
		User.sendIfWithinRange(message, User.findUserByName(name).getLocation(), range);
	}
}
