package com.tl.demo.test;

public class test5 {
    public static void main(String[] args) {
        System.out.println(mi(5,5));
    }
    public static double mi(double height,int cishu){
        for(int i=0;i<cishu;i++){
            height=height * 0.6;
        }
        return  height;
    }
}
