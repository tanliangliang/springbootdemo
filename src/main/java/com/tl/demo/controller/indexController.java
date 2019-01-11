package com.tl.demo.controller;

import com.tl.demo.common.ServerResponse;
import com.tl.demo.setvice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class indexController {


@Autowired
private IUserService userService;
    @RequestMapping("/index")
    public ServerResponse<Map>login(){
        ServerResponse<Map>response=userService.login();
        return  response;
    }

    public static void main(String[] args) {
//        List<Map<String,String>>list=new ArrayList<>();
//        Map map=new HashMap();
//        map.put("id","1");
//        list.add(map);
//        Map<String,String>m=list.get(0);
//        String id=m.get("id");
//        Integer idd=Integer.valueOf(id);
//        List<Map<String,String>>result=new ArrayList<>();
//
//        System.out.println(idd);
//        List<String>list=new ArrayList<>();
//        list.add("糙");
//        list.add("草");
//
//        System.out.println(list);
//        Map<String,String>map=new HashMap<>();
//        map.put("草","cao");
//        map.put("糙","cao");
//        System.out.println(map);
//        System.out.println("------------------------");
//        List<Map<String,String>>list1=new ArrayList<>();
//        list1.add(map);
//        System.out.println(list1);
    Map<String,String>map=new HashMap<>();
    map.put("ss","ss");
      //  System.out.println(map.get());
    }

}
