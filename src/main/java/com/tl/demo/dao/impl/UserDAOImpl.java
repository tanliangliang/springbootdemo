package com.tl.demo.dao.impl;

import com.tl.demo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
public class UserDAOImpl extends JDBCBaseDAOImpl implements UserDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Map<String, String> selectLogin() {
        String sql="select * from user ";
        return jdbcTemplate.query(sql,new ResultSetExtractorImpl());
    }

    @Override
    public int check(String username,String zdm) {
        String sql="select count(1) from user where "+zdm+"=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,username);
    }

    @Override
    public Map<String, String> login(String username, String pwd) {
        String sql="select * from user where username=? and password=? ";
        return jdbcTemplate.query(sql,new ResultSetExtractorImpl(),username,pwd);
    }

    @Override
    public int insert(Map map) {
        String sql="insert into user ( username, password, " +
                "  email, phone, question, answer, role, create_time,  update_time)  " +
                "  values ( ?,?,?,?,?, ?,?, now(),now())";
        return jdbcTemplate.update(sql,new Object[] {map.get("username"),map.get("password"),
       map.get("email"),map.get("phone"),map.get("question"),map.get("answer"),map.get("role")} );
    }
}
