package com.tl.demo.dao.impl;

import com.tl.demo.dao.JDBCbaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class JDBCBaseDAOImpl extends  Comm implements JDBCbaseDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Map<String, String>> queryBySQLAndArrprams(String sql, Object... params) {
        List<Map<String,String>>results=jdbcTemplate.query(sql,params,new ResultSetExtractorListImpl());
        return results;
    }

}
