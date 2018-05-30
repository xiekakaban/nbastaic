package com.vita.service;

import com.alibaba.fastjson.JSON;
import com.vita.basemapper.IMapper;
import com.vita.entity.Team;
import com.vita.mapper.ITeamMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by bobo on 2018/5/9.
 *
 * @email ruantianbo@163.com
 */
@Service("teamService")
@Transactional
public class TeamService extends AbstractService<Team>{
    private static final Logger logger = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    private ITeamMapper teamMapper;

    public TeamService() {
    }

    public Team getByUrl(String url){
        Example example = new Example(Team.class);
        example.createCriteria().andEqualTo("url",url);
        return getIMapper().selectOneByExample(example);
    }

    public Team getByUrlLike(String url){
        Example example = new Example(Team.class);
        example.createCriteria().andLike("url","%"+url+"%");
        return getIMapper().selectOneByExample(example);
    }

    public List<Team> getPerTeamsOrderByUrl(Integer currPage,Integer pageSize,String sort,String orderType){
        return teamMapper.getTeamByPageSorted(currPage,pageSize,sort,orderType);
    }


    @Override
    public IMapper<Team> getIMapper() {
        return teamMapper;
    }
}
