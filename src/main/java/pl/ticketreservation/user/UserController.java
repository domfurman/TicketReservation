package pl.ticketreservation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ticketreservation.user.userrepository.JdbcUserRepository;

@RestController
public class UserController {

    private final JdbcUserRepository jdbcUserRepository;

    @Autowired
    public UserController(JdbcUserRepository jdbcUserRepository) {this.jdbcUserRepository = jdbcUserRepository;}

    @PostMapping(value = "/make-new-user")
    public int makeUser(@RequestBody User user){
        return jdbcUserRepository.makeUser(user);
    }
}
