package pl.ticketreservation;
import org.junit.jupiter.api.Test;
import pl.ticketreservation.user.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void thereIsClient() {
        User user = new User();

        assertNotNull(user);
    }
}
