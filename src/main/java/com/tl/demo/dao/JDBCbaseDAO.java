package com.tl.demo.dao;

import java.util.List;
import java.util.Map;

public interface JDBCbaseDAO {
    List<Map<String,String>>queryBySQLAndArrprams(String sql,Object ... params);
}
