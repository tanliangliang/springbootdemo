package com.tl.demo.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultSetExtractorListImpl  extends Comm implements ResultSetExtractor<List<Map<String,String>>>{
    @Nullable
    @Override
    public List<Map<String, String>> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Map<String,String>>result=new ArrayList<Map<String ,String>>();
        String[]fiedNameArr=getFieldNameArr(resultSet);
        while (resultSet.next()){
            result.add(getMapString(resultSet,fiedNameArr));
        }
        return result       ;
    }
}
