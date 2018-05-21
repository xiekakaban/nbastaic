package com.vita.service;

import com.vita.basemapper.IMapper;
import com.vita.entity.MatchPlayer;
import com.vita.mapper.IMatchPlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bobo on 2018/5/21.
 *
 * @email ruantianbo@163.com
 */
@Service
public class MatchPlayerService extends AbstractService<MatchPlayer> {

    @Autowired
    private IMatchPlayerMapper matchPlayerMapper;
    @Override
    public IMapper<MatchPlayer> getIMapper() {
        return matchPlayerMapper;
    }
}
