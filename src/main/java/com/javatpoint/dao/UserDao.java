package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.javatpoint.beans.User;

public class UserDao {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(User u) {
        String sql = "insert into user(name, salary, designation) values('" + u.getName() + "'," + u.getSalary() + ",'" + u.getDesignation() + "')";
        return template.update(sql);
    }

    public int update(User u) {
        String sql = "update user set name='" + u.getName() + "', salary=" + u.getSalary() + ", designation='" + u.getDesignation() + "' where id=" + u.getId();
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "delete from user where id=" + id;
        return template.update(sql);
    }

    public User getUserById(int id) {
        String sql = "select * from user where id=?";
        return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
    }

    public List<User> getUsers() {
        return template.query("select * from user", new RowMapper<User>() {
            public User mapRow(ResultSet rs, int row) throws SQLException {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setSalary(rs.getFloat(3));
                u.setDesignation(rs.getString(4));
                return u;
            }
        });
    }
}