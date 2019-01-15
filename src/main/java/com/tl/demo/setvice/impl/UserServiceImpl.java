package com.tl.demo.setvice.impl;

import com.tl.demo.common.Const;
import com.tl.demo.common.ServerResponse;
import com.tl.demo.common.TokenCache;
import com.tl.demo.dao.UserDAO;
import com.tl.demo.setvice.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserDAO userDAO;
    @Override
    public ServerResponse<Map> login() {

        Map map=userDAO.selectLogin();

        return ServerResponse.createBySuccess("查询成功！",map);
    }

    @Override
    public ServerResponse<Map> logins(String username, String pwd) {
        //检查用户名
        int resultCount=userDAO.check(username,Const.zdm.USERNAME);
        if(resultCount==0)return  ServerResponse.createByErrorMessage("用户名不存在");
        //登陆验证
        Map map=userDAO.login(username,pwd);
        if(map==null ||map.size()==0)return  ServerResponse.createByErrorMessage("密码错误");
        return ServerResponse.createBySuccess("登陆成功！",map);
    }

    @Override
    public ServerResponse<String> register(Map map) {
        ServerResponse response=this.checkValid(map.get("username").toString(), Const.USERNAME);
        if(!response.isSuccess()) return response;
        response = this.checkValid(map.get("email").toString(),Const.EMAIL);
        if(!response.isSuccess())return response;
        map.put("role",Const.Role.ROLE_CUSTOMER);
       if(userDAO.insert(map)==0) return ServerResponse.createByErrorMessage("注册失败");
        return ServerResponse.createBySuccessMessage("注册成功");
    }

    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        if(StringUtils.isNoneBlank(type)){
            //开始校验
            if(Const.USERNAME.equals(type)){
                int resultCount = userDAO.check(str,Const.zdm.USERNAME);
                if(resultCount > 0 ){
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }
            if(Const.EMAIL.equals(type)){
                int resultCount = userDAO.check(str,Const.zdm.EMAIL);
                if(resultCount > 0 ){
                    return ServerResponse.createByErrorMessage("email已存在");
                }
            }
        }else{
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }

    @Override
    public ServerResponse selectQuestion(String username) {
        ServerResponse response=this.checkValid(username,Const.USERNAME);
        if(response.isSuccess()){
            //用户不存在
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String question=userDAO.selectQuestion(username);
        if(StringUtils.isNoneBlank(question)) return ServerResponse.createBySuccess(question);
        return ServerResponse.createByErrorMessage("找回密码的问题是空的");
    }

    @Override
    public ServerResponse<String> checkAnswer(String username, String question, String answer) {
        int resultCount = userDAO.checkAnswer(username,question,answer);
        if(resultCount>0){
            //说明问题及问题答案是这个用户的,并且是正确的
            String forgetToken = UUID.randomUUID().toString();
            TokenCache.setKey(TokenCache.TOKEN_PREFIX+username,forgetToken);
            return ServerResponse.createBySuccess(forgetToken);
        }
        return ServerResponse.createByErrorMessage("问题的答案错误");
    }


}
