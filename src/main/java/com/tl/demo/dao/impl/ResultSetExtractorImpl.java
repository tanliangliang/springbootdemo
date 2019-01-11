package com.tl.demo.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ResultSetExtractorImpl extends  Comm  implements ResultSetExtractor<Map<String ,String>>{
    @Nullable
    @Override
    public Map<String, String> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<String,String >result=new HashMap<>();
        String[]fieldNameArr=getFieldNameArr(resultSet);
        if(resultSet.next()){
            result=getMapString(resultSet,fieldNameArr);
        }
        return result;
    }
}
