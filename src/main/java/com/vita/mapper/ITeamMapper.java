package com.vita.mapper;

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
public interface ITeamMapper {
    int add(@Param("tm") Team team);
    List<Team> getAll();
}
