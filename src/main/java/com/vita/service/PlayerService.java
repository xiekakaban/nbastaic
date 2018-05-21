package com.vita.service;

import com.vita.basemapper.IMapper;
import com.vita.entity.Player;
import com.vita.mapper.IPlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * Created by bobo on 2018/5/18.
 *
 * @email ruantianbo@163.com
 */
@Service("playerService")
public class PlayerService extends AbstractService<Player>{

    @Autowired
    private IPlayerMapper playerMapper;


    @Override
    public IMapper<Player> getIMapper() {
        return playerMapper;
    }

    public Player getByUrl(String url){
        Example example = new Example(Player.class);
        example.createCriteria().andEqualTo("url",url);
        return getIMapper().selectOneByExample(example);
    }

    public Player getByUrlLike(String url){
        Example example = new Example(Player.class);
        example.createCriteria().andLike("url","%"+url+"%");
        return getIMapper().selectOneByExample(example);
    }

}
