package pl.ticketreservation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ticketreservation.user.userrepository.JdbcUserRepository;

import java.util.List;

@RestController
public class UserController {

    private final JdbcUserRepository jdbcUserRepository;

    @Autowired
    public UserController(JdbcUserRepository jdbcUserRepository) {this.jdbcUserRepository = jdbcUserRepository;}

    @GetMapping(path = "/api/users")
    public List<User> getAllUsers() {
        return jdbcUserRepository.findAll();
    }

    @PostMapping(value = "/make-new-user")
    public ResponseEntity<Integer> makeUser(@RequestBody User user){
        Integer u = jdbcUserRepository.makeUser(user);
        return ResponseEntity.ok(u);
    }


}
