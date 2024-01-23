package pl.ticketreservation.user.userrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    @Override
    public User getUserInfoByTicketId(int ticketId) {
        return jdbcTemplate.queryForObject("""
                SELECT u.userId, u.name, u.surname
                FROM user u
                JOIN ticket t ON u.userId = t.userId
                WHERE t.ticketId = ?
                """,
                BeanPropertyRowMapper.newInstance(User.class), ticketId);
    }
}
