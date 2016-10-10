package shouty;

public class Message {
    private int location;
    private String message;

    public Message(String message, int location) {
        this.message = message;
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public String getMessage() {
        return message;
    }
}
