package com.vita.service;

import com.vita.basemapper.IMapper;

import java.util.List;

/**
 * Created by bobo on 2018/5/17.
 *
 * @email ruantianbo@163.com
 */
public abstract class AbstractService<T> extends AbstrctSelService<T> {

    public abstract IMapper<T> getIMapper();

    public int insert(T record) {

        return getIMapper().insert(record);
    }

    public int insertSelective(T record) {
        return getIMapper().insertSelective(record);
    }

    public int updateByPrimaryKey(T record) {
        return getIMapper().updateByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(T record) {
        return getIMapper().updateByPrimaryKeySelective(record);
    }

    public int delete(T record) {
        return getIMapper().delete(record);
    }

    public int deleteByPrimaryKey(Object key) {
        return getIMapper().deleteByPrimaryKey(key);
    }

    public int deleteByExample(Object example) {
        return getIMapper().deleteByExample(example);
    }

    public int updateByExample(T record, Object example) {
        return getIMapper().updateByExample(record, example);
    }

    public int updateByExampleSelective(T record, Object example) {
        return getIMapper().updateByExampleSelective(record, example);
    }

    public int insertList(List<T> recordList) {
        return getIMapper().insertList(recordList);
    }

    public int insertUseGeneratedKeys(T record) {
        return getIMapper().insertUseGeneratedKeys(record);
    }


}
