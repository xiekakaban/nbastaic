package com.vita.service;

import com.vita.basemapper.IMapper;
import com.vita.entity.MatchTeam;
import com.vita.mapper.IMatchTeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bobo on 2018/5/21.
 *
 * @email ruantianbo@163.com
 */
@Service
public class MatchTeamService extends AbstractService<MatchTeam> {
    @Autowired
    private IMatchTeamMapper matchTeamMapper;

    @Override
    public IMapper<MatchTeam> getIMapper() {
        return matchTeamMapper;
    }
}
