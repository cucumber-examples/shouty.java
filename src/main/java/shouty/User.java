package shouty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

	private static Map<String, User> users = new HashMap<String, User>();
	private String name;
	private List<String> messages = new ArrayList<String>();
	private int location;

	public static void restart() {
		users.clear();
	}

	public User(String name) {
		this.name = name;
		users.put(name, this);
	}

	public static User findUserByName(String name) {
		// Eventually this will use a DAO to lookup in database
		// For now, I'll use an in memory collection
		User user = users.get(name);
		if (null == user) {
			user = new User(name);
		}
		return user;
	}

	public void setLocation(int location) {
		this.location = location;
	}
	
	public int getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public static void sendIfWithinRange(String message, int origin, int range) {
		for (User user : users.values()) {
			// TODO this math won't always work
			if (user.getLocation() - origin < range) {
				user.sendMessage(message);
			}
		}
	}

	public void sendMessage(String message) {
		messages.add(message);
	}

	public String[] getMessages() {
		return messages.toArray(new String[messages.size()]);
	}

}
