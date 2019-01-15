package com.tl.demo.controller.portal;

import com.tl.demo.common.Const;
import com.tl.demo.common.ServerResponse;
import com.tl.demo.setvice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserConroller {
    @Autowired
    private IUserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse<Map>login(String username, String  pwd, HttpSession session){
        ServerResponse<Map>response=userService.logins(username,pwd);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response);
        }
        return response;
    }
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ServerResponse<String>register(@RequestBody  Map map){
        return  userService.register(map);
    }

    @RequestMapping(value = "/check_valid",method = RequestMethod.POST)
    public ServerResponse<String>check( String str,String type){
        return  userService.checkValid(str,type);
    }

    @RequestMapping("/getUserInfo")
    public ServerResponse<Map>getUserInfo(HttpSession session){
        ServerResponse<Map>response= (ServerResponse<Map>) session.getAttribute(Const.CURRENT_USER);
       if( session.getAttribute(Const.CURRENT_USER)!=null){
           return response;
       }
        return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
    }

    @RequestMapping(value = "/foget_get_question",method = RequestMethod.POST)
    public ServerResponse<String>forgetquestion(String username){
        return userService.selectQuestion(username);
    }

    @RequestMapping(value = "/forget_check_answer",method = RequestMethod.POST)
    public ServerResponse<String> forgetCheckAnswer(String username,String question,String answer){
        return userService.checkAnswer(username,question,answer);
    }
}
