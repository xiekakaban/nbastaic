package com.vita.service;

import com.vita.basemapper.IMapper;
import com.vita.entity.Player;
import com.vita.mapper.IPlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
