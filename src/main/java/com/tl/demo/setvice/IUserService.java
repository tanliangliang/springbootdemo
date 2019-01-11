package com.tl.demo.setvice;

import com.tl.demo.common.ServerResponse;

import java.util.Map;

public interface IUserService {
    ServerResponse<Map>login();
}
