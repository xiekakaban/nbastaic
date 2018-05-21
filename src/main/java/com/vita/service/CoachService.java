package com.vita.service;

import com.vita.basemapper.IMapper;
import com.vita.entity.Coach;
import com.vita.entity.Player;
import com.vita.mapper.ICoachMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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


    public Coach getByUrl(String url){
        Example example = new Example(Coach.class);
        example.createCriteria().andEqualTo("url",url);
        return getIMapper().selectOneByExample(example);
    }

    public Coach getByUrlLike(String url){
        Example example = new Example(Coach.class);
        example.createCriteria().andLike("url","%"+url+"%");
        return getIMapper().selectOneByExample(example);
    }
}
