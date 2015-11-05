package shouty;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by paul on 11/5/15.
 */
public class BroadcastTest {

    @Test
    public void transmits_a_message_to_all_listeners() {
        Broadcast broadcast = new Broadcast();
        String message = "Free bagels!";
        Subscriber lucy = mock(Subscriber.class);
        broadcast.subscribe(lucy);
        broadcast.transmit(message);
        verify(lucy).hear(message);
    }
}
