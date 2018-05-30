package com.vita.mapper;

import com.vita.basemapper.IMapper;
import com.vita.entity.Player;
import com.vita.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by bobo on 2018/5/11.
 *
 * @email ruantianbo@163.com
 */
@Mapper
public interface ITeamMapper extends IMapper<Team> {

    List<Team> getTeamByPageSorted(@Param("currPage") Integer currPage, @Param("pageSize") Integer pageSize,@Param("sort") String sort,@Param("orderType") String orderType);
}
