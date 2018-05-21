package com.vita.service;

import com.vita.basemapper.IMapper;
import com.vita.entity.Match;
import com.vita.mapper.IMatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bobo on 2018/5/21.
 *
 * @email ruantianbo@163.com
 */
@Service
public class MatchService extends AbstractService<Match> {

    @Autowired
    private IMatchMapper matchMapper;

    @Override
    public IMapper<Match> getIMapper() {
        return matchMapper;
    }
}
