package com.vita.service;

import com.vita.basemapper.IMapper;
import com.vita.entity.TeamPlayer;
import com.vita.mapper.ITeamMapper;
import com.vita.mapper.ITeamPlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bobo on 2018/5/24.
 *
 * @email ruantianbo@163.com
 */
@Service("teamPlayerService")
public class TeamPlayerService extends AbstractService<TeamPlayer> {

    @Autowired
    private ITeamPlayerMapper mapper;

    @Override
    public IMapper<TeamPlayer> getIMapper() {
        return mapper;
    }
}
