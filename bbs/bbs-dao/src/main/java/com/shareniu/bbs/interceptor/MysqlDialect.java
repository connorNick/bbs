//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package com.shareniu.bbs.interceptor;
import com.shareniu.bbs.common.common.Pageable;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;

import org.apache.ibatis.mapping.ParameterMapping.Builder;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class MysqlDialect implements Dialect {
    public MysqlDialect() {
    }

    public String buildPageSqlAndSetParameters(MappedStatement mappedStatement, String sql, Pageable page, Map<String, Object> pageParameters, List<ParameterMapping> parameterMappings) {
        StringBuilder pageSql = new StringBuilder(100);
        Integer beginrow = Integer.valueOf((page.getCurrentPage() - 1) * page.getPageSize());
        pageSql.append(sql);
        pageSql.append(" limit ?,?");
        pageParameters.put("__offset", beginrow);
        ParameterMapping parameterMapping = (new Builder(mappedStatement.getConfiguration(), "__offset", Integer.class)).build();
        parameterMappings.add(parameterMapping);
        pageParameters.put("__limit", Integer.valueOf(page.getPageSize()));
        parameterMapping = (new Builder(mappedStatement.getConfiguration(), "__limit", Integer.class)).build();
        parameterMappings.add(parameterMapping);
        return pageSql.toString();
    }
   /* public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bbs", "root", "root");
            Statement st = con.createStatement();
            //插入一个空对象empty_blob()
            //st.executeUpdate("insert into TESTBLOB (ID, NAME, BLOBATTR) values (1, "thename", empty_blob())");
            //锁定数据行进行更新，注意“for update”语句
            ResultSet rs = st.executeQuery("select content from topic where id=9");
            if (rs.next()) {
                //得到java.sql.Blob对象后强制转换为oracle.sql.BLOB
                *//*Blob blob = rs.getBlob("content");*//*
                byte[] content=rs.getBytes("content");
                //byte[] b = blob.getBytes(1, (int)blob.length());
                String result = new String(content);
                System.out.println(result);
            }
            con.commit();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }*/
}
