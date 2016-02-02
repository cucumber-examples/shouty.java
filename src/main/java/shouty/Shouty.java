package shouty;

import java.util.ArrayList;
import java.util.List;

public class Shouty {

	private List<String> messages = new ArrayList<String>();

	public void setMaxRange(int distance) {
		// TODO Auto-generated method stub

	}
	// This is where we'll write the code of our Shouty app

	public void setUserLocation(String name, int location) {
		User user = User.findUserByName(name);
		user.setLocation(location);
	}

	public String[] getMessagesFor(String name) {
		return messages.toArray(new String[messages.size()]);
	}

	public void send(String name, String message) {
		messages.add(message);
	}
}
