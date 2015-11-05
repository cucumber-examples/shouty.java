package shouty;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SubscriberTest {
    private final Broadcast broadcast = mock(Broadcast.class);

    @Test
    public void it_subscribes_to_the_broadcast() {
        Subscriber lucy = new Subscriber(broadcast);
        verify(broadcast).subscribe(lucy);
    }

    @Test
    public void broadcasts_shouts_to_the_broadcast() {
        String message = "Free bagels!";
        Subscriber sean = new Subscriber(broadcast);
        sean.shout(message);
        verify(broadcast).transmit(message);
    }

    @Test
    public void remembers_messages_heard() {
        String message = "Free bagels!";
        Subscriber lucy = new Subscriber(broadcast);
        lucy.hear(message);
        assertEquals(asList(message), lucy.getMessagesHeard());
    }
}
