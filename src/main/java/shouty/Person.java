package shouty;

public class Person {

	private Shouty network;
	private String lastMessageHeard = "";

	public Person(Shouty shouty) {
		this.network = shouty;
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
