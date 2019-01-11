package com.tl.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Comm {
    public String[]getFieldNameArr(ResultSet rs)throws SQLException{
        //获取取出来的列名与个数
        ResultSetMetaData rsmd=rs.getMetaData();
        String[]fieldNameArr=new String[rsmd.getColumnCount()];
        for (int i=0;i<rsmd.getColumnCount();i++){
            fieldNameArr[i]=rsmd.getColumnName(i+1).toLowerCase();
        }
        return fieldNameArr;
    }
    //获取rs中的值并且生成Map返回
    public Map<String,String>getMapString(ResultSet rs,String[]arr)throws  SQLException{
        Map<String,String>map=new HashMap<String, String>();
        //循环取值
        for(String fieldName:arr){
            map.put(fieldName,rs.getString(fieldName)==null?"":rs.getString(fieldName));
        }
        return map;
    }
}
