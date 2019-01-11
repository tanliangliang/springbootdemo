package com.tl.demo.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class test3 {
    static{
        System.out.println("sb");
    }
    static {
        System.out.println("sss");
    }

private static String a="aaaa";

    public static void main(String[] args)throws Exception{
        List<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);

        Class clazz=list.getClass();
        Method method=clazz.getMethod("add",Object.class);
        method.invoke(list,"ss");
        System.out.println(list);
        ClassLoader loader = Thread.currentThread().getContextClassLoader();





            Class<?> obj =loader.loadClass("com.tl.demo.test.test2");
            Field[] f = obj.getDeclaredFields();
            for(Field field : f){
                field.setAccessible(true);
                System.out.println(field.getName()+":"+field.get(obj.newInstance()));
            }

        String a="22";
        System.out.println(a.hashCode());
        char[] value ={'a','b','c','d'};
        String str=new String(value);

        System.out.println(str);
    }
}
