package com.vita.mapper;

import com.vita.basemapper.IMapper;
import com.vita.basemapper.ISelectedMapper;
import com.vita.entity.Person;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by bobo on 2018/5/17.
 *
 * @email ruantianbo@163.com
 */
@Mapper
public interface IPersonMapper extends IMapper<Person> {
}
