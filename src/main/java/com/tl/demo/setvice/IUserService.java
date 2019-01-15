package com.tl.demo.setvice;

import com.tl.demo.common.ServerResponse;

import java.util.Map;

public interface IUserService {
    ServerResponse<Map>login();
    ServerResponse<Map>logins(String username,String pwd);
    ServerResponse<String>register(Map map);
    ServerResponse<String> checkValid(String str,String type);
    ServerResponse selectQuestion(String username);
}
