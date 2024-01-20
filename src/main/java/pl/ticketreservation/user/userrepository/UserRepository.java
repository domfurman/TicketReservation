package pl.ticketreservation.user.userrepository;

import pl.ticketreservation.user.User;

public interface UserRepository {

    public int makeUser(User user);

    User getUserInfoByTicketId(int ticketId);
}
