package com.vita.interceptor;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * Created by bobo on 2018/5/30.
 *
 * @email ruantianbo@163.com
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args ={Connection.class, Integer.class} )})
public class SortInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //获取statementHandler
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        //获取 包装类
        MetaObject MetaObjectHandler = SystemMetaObject.forObject(statementHandler);
        while (MetaObjectHandler.hasGetter("h")) {
            Object obj = MetaObjectHandler.getValue("h");
            MetaObjectHandler = SystemMetaObject.forObject(obj);
        }

        while (MetaObjectHandler.hasGetter("target")) {
            Object obj = MetaObjectHandler.getValue("target");
            MetaObjectHandler = SystemMetaObject.forObject(obj);
        }
        MappedStatement mappedStatement = (MappedStatement) MetaObjectHandler.getValue("delegate.mappedStatement");
        String mapId = mappedStatement.getId();
        if(mapId.matches(".+Sorted.*")){
            ParameterHandler parameterHandler = (ParameterHandler) MetaObjectHandler.getValue("delegate.parameterHandler");
            //获取请求时的参数
            Map<String, Object> paraObject = (Map<String, Object>) parameterHandler.getParameterObject();
            String sort = (String)paraObject.get("sort");
            String orderType = (String)paraObject.get("orderType");
            String sql = (String) MetaObjectHandler.getValue("delegate.boundSql.sql");
            String sortSql = sql+" order by "+ sort + " "+orderType;
            MetaObjectHandler.setValue("delegate.boundSql.sql", sortSql);

        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
