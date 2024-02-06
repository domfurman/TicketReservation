package pl.ticketreservation.user.userrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.ticketreservation.user.User;

import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM user",
                BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public int makeUser(User user){
        Object[] params = {user.getName(), user.getSurname()};
        try {
            jdbcTemplate.queryForObject("SELECT userId FROM user WHERE name = ? AND surname = ?", params, int.class);
            return -1;
        } catch (EmptyResultDataAccessException e){
            jdbcTemplate.update("INSERT INTO user (name, surname, email) VALUES (?, ?, ?)", user.getName(), user.getSurname(), user.getEmail());
            return jdbcTemplate.queryForObject("SELECT userId FROM user WHERE name = ? AND surname = ?", params, int.class);
        }
    }

    @Override
    public User getUserInfoByTicketId(int ticketId) {
        return jdbcTemplate.queryForObject("""
                SELECT u.userId, u.name, u.surname, u.email
                FROM user u
                JOIN ticket t ON u.userId = t.userId
                WHERE t.ticketId = ?
                """,
                BeanPropertyRowMapper.newInstance(User.class), ticketId);
    }

    @Override
    public User getUserByEmail(String email) {
       return jdbcTemplate.queryForObject("SELECT * FROM user WHERE email = ?", BeanPropertyRowMapper.newInstance(User.class), email);
    }
}
