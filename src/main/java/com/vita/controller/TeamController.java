package com.vita.controller;

import com.vita.entity.Team;
import com.vita.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by bobo on 2018/5/11.
 *
 * @email ruantianbo@163.com
 */
@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @ResponseBody
    @GetMapping("/all")
    private List<Team> getAllTeam(){
        return teamService.getAll();
    }

    @GetMapping("/add")
    private int add(){
        Team team = new Team();
        team.setPosition("中部");
        team.setImgUrl("asdas.jpg");
        team.setName("华强北");
        team.setIsCurrent(Boolean.FALSE);
        team.setUrl("wasd.asda.com");
        return teamService.save(team);

    }

}
