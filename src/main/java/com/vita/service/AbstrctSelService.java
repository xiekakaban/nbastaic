package com.vita.service;

import com.vita.basemapper.IMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
/**
 * Created by bobo on 2018/5/17.
 *
 * @email ruantianbo@163.com
 */
public abstract class AbstrctSelService<T> {

    private final Object tClassLock = new Object();
    private Class<?> tClass;

    public abstract IMapper<T> getIMapper();

    public T selectOne(T record) {
        List<T> list = selectByRowBounds(record, new RowBounds(0, 1));
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    public List<T> select(T record) {
        return getIMapper().select(record);
    }

    public List<T> selectAll() {
        return getIMapper().selectAll();
    }

    public int selectCount(T record) {
        return getIMapper().selectCount(record);
    }

    public T selectByPrimaryKey(Object key) {
        return getIMapper().selectByPrimaryKey(key);
    }


    public List<T> selectByExampleAndRowBounds(Object example,
                                               RowBounds rowBounds) {
        return getIMapper().selectByExampleAndRowBounds(example, rowBounds);
    }

    public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
        return getIMapper().selectByRowBounds(record, rowBounds);
    }

    public List<T> selectByExample(Object example) {
        return getIMapper().selectByExample(example);
    }

    public int selectCountByExample(Object example) {
        return getIMapper().selectCountByExample(example);
    }

    private Class<?> getGenericInterfaces() {
        if (tClass != null) {
            return tClass;
        }
        synchronized (tClassLock) {
            Type type = this.getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                ParameterizedType t = (ParameterizedType) type;
                tClass = (Class<?>) t.getActualTypeArguments()[0];
            }
        }
        return tClass;
    }

    public T selectOneByExample(Object example) {
        List<T> list = selectByExampleAndRowBounds(example, new RowBounds(0, 1));
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }
    public int insert(T entity){
        return getIMapper().insert(entity);
    }
    public Example example() {
        return new Example(getGenericInterfaces());
    }

}
