package com.tl.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 七月.2018-10-13 15:06
 */
@RestController
public class indexController {

    @RequestMapping("/index")
    public String index(){
        return "hello!!!";
    }
}
