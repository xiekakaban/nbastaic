package com.vita.service;

import com.vita.basemapper.IMapper;
import com.vita.entity.Person;
import com.vita.mapper.IPersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bobo on 2018/5/17.
 *
 * @email ruantianbo@163.com
 */
@Service("personService")
public class PersonService extends AbstractService<Person>{
    @Autowired
    private IPersonMapper mapper;

    @Override
    public IMapper<Person> getIMapper() {
        return mapper;
    }
}
