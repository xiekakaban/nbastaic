package com.vita.basemapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by bobo on 2018/5/17.
 *
 * @email ruantianbo@163.com
 */
public interface IMapper<T> extends
        Mapper<T>,
        MySqlMapper<T>,
        ISelectedMapper<T> {
}
