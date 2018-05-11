package com.vita.service;

import com.alibaba.fastjson.JSON;
import com.vita.entity.Team;
import com.vita.mapper.ITeamMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by bobo on 2018/5/9.
 *
 * @email ruantianbo@163.com
 */
@Service("teamService")
@Transactional
public class TeamService {
    private static final Logger logger = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    private ITeamMapper teamMapper;

    public TeamService() {
    }

    public String save(Team team){
        logger.debug("saving->\t"+ JSON.toJSONString(team));
        return team.getId();
    }

    public List<Team> getAll(){
        return teamMapper.getAll();
    }



}
