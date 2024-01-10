package pl.ticketreservation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    void thereIsClient() {
        Client client = new Client();

        assertNotNull(client);
    }
}
