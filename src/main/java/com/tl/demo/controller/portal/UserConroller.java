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

}
