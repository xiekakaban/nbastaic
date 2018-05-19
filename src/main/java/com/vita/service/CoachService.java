package com.vita.service;

import com.vita.basemapper.IMapper;
import com.vita.entity.Coach;
import com.vita.mapper.ICoachMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bobo on 2018/5/18.
 *
 * @email ruantianbo@163.com
 */
@Service("coachService")
public class CoachService extends AbstractService<Coach> {

    @Autowired
    private ICoachMapper coachMappere;

    @Override
    public IMapper<Coach> getIMapper() {
        return coachMappere;
    }
}
