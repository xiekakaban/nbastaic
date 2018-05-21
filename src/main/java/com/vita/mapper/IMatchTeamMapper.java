package com.vita.mapper;

import com.vita.basemapper.IMapper;
import com.vita.entity.MatchPlayer;
import com.vita.entity.MatchTeam;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by bobo on 2018/5/21.
 *
 * @email ruantianbo@163.com
 */
@Mapper
public interface IMatchTeamMapper extends IMapper<MatchTeam> {
}
