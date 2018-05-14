package com.vita.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bobo on 2018/5/11.
 *
 * @email ruantianbo@163.com
 */
@MappedTypes(Boolean.class)
@MappedJdbcTypes(JdbcType.SMALLINT)
public class BooleanVarcharTypeHandler implements TypeHandler<Boolean>{

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,aBoolean?1:0);
    }

    @Override
    public Boolean getResult(ResultSet resultSet, String s) throws SQLException {
        return (resultSet.getInt(s)==1?Boolean.TRUE:Boolean.FALSE);
    }

    @Override
    public Boolean getResult(ResultSet resultSet, int i) throws SQLException {
        return (resultSet.getInt(i)==1?Boolean.TRUE:Boolean.FALSE);
    }

    @Override
    public Boolean getResult(CallableStatement callableStatement, int i) throws SQLException {
        return (callableStatement.getInt(i)==1?Boolean.TRUE:Boolean.FALSE);
    }
}
