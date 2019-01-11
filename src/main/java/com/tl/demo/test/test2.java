package com.tl.demo.test;

public class test2 {
    private  String tt="2";

    static String a="1";
    String b="1";
    public static void main(String[] args) {
        System.out.println(a);
       // System.out.println(b);
        //this.t();
        test2 t=new test2();
        t.t();
    }
        public void ss(){
        this.t();
        }
    public  void t(){
        System.out.println(a);
        System.out.println(b);
    }
}
