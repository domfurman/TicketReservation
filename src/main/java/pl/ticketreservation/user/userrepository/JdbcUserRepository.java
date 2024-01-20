package pl.ticketreservation.user.userrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.ticketreservation.user.User;

@Repository
public class JdbcUserRepository implements UserRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int makeUser(User user){
        Object[] params = {user.getName(), user.getSurname()};
        try {
            jdbcTemplate.queryForObject("SELECT userId FROM user WHERE name = ? AND surname = ?", params, int.class);
            return -1;
        } catch (EmptyResultDataAccessException e){
            jdbcTemplate.update("INSERT INTO user (name, surname) VALUES (?, ?)", user.getName(), user.getSurname());
            return jdbcTemplate.queryForObject("SELECT userId FROM user WHERE name = ? AND surname = ?", params, int.class);
        }
    }
}
