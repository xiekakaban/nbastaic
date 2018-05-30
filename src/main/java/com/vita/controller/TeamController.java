package com.vita.controller;

import com.geccocrawler.gecco.annotation.RequestParameter;
import com.vita.entity.ResultBack;
import com.vita.entity.Team;
import com.vita.service.TeamService;
import com.vita.util.ResultBackUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by bobo on 2018/5/11.
 *
 * @email ruantianbo@163.com
 */
@Controller
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @ResponseBody
    @GetMapping("/")
    private ResultBack getAllTeam(){
        List<Team> teams = teamService.selectAll();
        return ResultBackUtil.success(teams);
    }

    @ResponseBody
    @GetMapping("/query")
    private ResultBack getAllTeam(@RequestParam("currPage") Integer currPage, @RequestParam("pageSize") Integer pageSize,@RequestParam("sort") String sort,@RequestParam("order") String orderType){
        List<Team> teams = teamService.getPerTeamsOrderByUrl(currPage,pageSize,sort,orderType);
        return ResultBackUtil.success(teams);
    }


}
