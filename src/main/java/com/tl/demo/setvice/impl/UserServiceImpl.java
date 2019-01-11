package com.tl.demo.setvice.impl;

import com.tl.demo.common.ServerResponse;
import com.tl.demo.dao.UserDAO;
import com.tl.demo.setvice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserDAO userDAO;
    @Override
    public ServerResponse<Map> login() {

        Map map=userDAO.selectLogin();

        return ServerResponse.createBySuccess("查询成功！",map);
    }
}
