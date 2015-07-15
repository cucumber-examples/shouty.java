package shouty.core;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NetworkTest {
    private int range = 100;
    private Network network = new Network(range);
    private String message = "Free bagels!";

    // Broadcasting

    @Test
    public void broadcasts_a_message_to_a_listener_within_range() {
        Person sean = mock(Person.class);
        when(sean.getLocation()).thenReturn(0);
        Person lucy = mock(Person.class);
        network.subscribe(lucy);
        network.broadcast(message, sean);

        verify(lucy).hear(message);
    }

    @Test
    public void does_not_broadcast_a_message_to_a_litener_out_of_range() {
        Person sean = mock(Person.class);
        when(sean.getLocation()).thenReturn(0);
        Person laura = mock(Person.class);
        when(laura.getLocation()).thenReturn(101);
        network.subscribe(laura);
        network.broadcast(message, sean);

        verify(laura, never()).hear(message);
    }

    @Test
    public void does_not_broadcast_a_message_to_a_litener_out_of_range_negative_distance() {
        Person sally = mock(Person.class);
        when(sally.getLocation()).thenReturn(101);
        Person lionel = mock(Person.class);
        when(lionel.getLocation()).thenReturn(0);
        network.subscribe(lionel);
        network.broadcast(message, sally);

        verify(lionel, never()).hear(message);
    }
}
