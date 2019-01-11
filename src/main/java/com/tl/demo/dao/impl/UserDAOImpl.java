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
}
