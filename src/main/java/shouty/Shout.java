package shouty;

public class Shout {
    public String person;
    public String message;
    public int x;
    public int y;

    public Shout(String person_, String message_) {
        person = person_;
        message = message_;
    }

    public Shout(String person_, String message_, int x_, int y_) {
        person = person_;
        message = message_;
        x = x_;
        y = y_;
    }
}
