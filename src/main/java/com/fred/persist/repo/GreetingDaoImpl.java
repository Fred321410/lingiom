package com.fred.persist.repo;

import com.fred.persist.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fred on 06/03/2017.
 */
@Repository
public class GreetingDaoImpl implements GreetingDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Greeting getById(int id){
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        String sql = "SELECT * FROM greetings WHERE id=:id";

        Greeting result = namedParameterJdbcTemplate.queryForObject(
                sql,
                params,
                new GreetingMapper());

        return result;
    }

    private static final class GreetingMapper implements RowMapper<Greeting> {

        public Greeting mapRow(ResultSet rs, int rowNum) throws SQLException {
            Greeting greeting = new Greeting();
            greeting.setId(rs.getInt("id"));
            greeting.setContent(rs.getString("content"));
            return greeting;
        }
    }
}
