package shouty;

public class Person {

	private Network network;
	private String lastMessageHeard = "";

	public Person(Network network) {
		this.network = network;
	}

	public String getLastMessageHeard() {
		return lastMessageHeard;
	}

	public void shout(String message) {
		network.broadcast(message);
	}

	public void hear(String message) {
		this.lastMessageHeard = message;
	}

}
