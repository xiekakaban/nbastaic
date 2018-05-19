package com.vita.basemapper;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.select.SelectAllMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;
import tk.mybatis.mapper.common.example.SelectCountByExampleMapper;
import tk.mybatis.mapper.common.rowbounds.SelectByExampleRowBoundsMapper;
import tk.mybatis.mapper.common.rowbounds.SelectRowBoundsMapper;

/**
 * Created by bobo on 2018/5/17.
 *
 * @email ruantianbo@163.com
 */
public interface ISelectedMapper<T> extends Marker,
        BaseSelectMapper<T>,
        SelectByExampleMapper<T>,
        SelectCountByExampleMapper<T>,
        SelectByExampleRowBoundsMapper<T>,
        SelectRowBoundsMapper<T>,
        SelectAllMapper<T> {
}
