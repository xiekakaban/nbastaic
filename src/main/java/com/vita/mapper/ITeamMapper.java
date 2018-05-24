package com.vita.mapper;

import com.vita.basemapper.IMapper;
import com.vita.entity.Player;
import com.vita.entity.Team;
import com.vita.entity.TeamPlayer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by bobo on 2018/5/11.
 *
 * @email ruantianbo@163.com
 */
@Mapper
public interface ITeamMapper extends IMapper<Team> {

    @Select("select * from tb_team where is_current=1")
    List<Team> getCurrentTeam();
}
