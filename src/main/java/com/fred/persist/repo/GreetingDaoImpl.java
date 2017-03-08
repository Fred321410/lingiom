package com.fred.persist.repo;

import com.fred.persist.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fred on 06/03/2017.
 */
@Repository
public class GreetingDaoImpl implements GreetingDao {

    @Autowired
    private DataSource dataSource;


    @Override
    public Greeting getById(int id){

        String sql = "SELECT * FROM greetings WHERE id = ?";

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            Greeting g = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                g = new Greeting(
                        rs.getInt("id"),
                        rs.getString("content")
                );
            }
            rs.close();
            ps.close();
            return g;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}
