package pl.ticketreservation.user.userrepository;

import pl.ticketreservation.user.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    public int makeUser(User user);

    User getUserInfoByTicketId(int ticketId);

    User getUserByEmail(String email);
}
