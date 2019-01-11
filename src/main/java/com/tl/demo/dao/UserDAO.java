package com.tl.demo.dao;

import java.util.Map;

public interface UserDAO extends JDBCbaseDAO{
    Map<String,String>selectLogin();
}
