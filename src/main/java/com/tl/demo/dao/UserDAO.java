package com.tl.demo.dao;

import java.util.Map;

public interface UserDAO extends JDBCbaseDAO{
    Map<String,String>selectLogin();
    int check(String username,String zdm);
    Map<String,String>login(String username,String pwd);
    int insert(Map map);
    String selectQuestion(String username);
    int checkAnswer(String username,String question,String answer);
}
