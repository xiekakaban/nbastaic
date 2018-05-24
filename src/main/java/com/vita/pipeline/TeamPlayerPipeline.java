package com.vita.pipeline;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.vita.entity.Player;
import com.vita.entity.TeamPlayer;
import com.vita.fetchbean.TeamPlayerBean;
import com.vita.service.PlayerService;
import com.vita.service.TeamPlayerService;
import com.vita.service.TeamService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by bobo on 2018/5/24.
 *
 * @email ruantianbo@163.com
 */
@Service("teamPlayerPipeline")
@PipelineName("teamPlayerPipeline")
public class TeamPlayerPipeline implements Pipeline<TeamPlayerBean> {
    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamPlayerService teamPlayerService;

    @Override
    public void process(TeamPlayerBean bean) {
        List<TeamPlayer> teamPlayerList = bean.getTeamPlayers();
        String season = "";
        //season=2016&col=pts&order=1&isseason=1
        String year = bean.getRequest().getParameter("season");
        String type = bean.getRequest().getParameter("isseason");
        year = year.substring(2);
        //14-15赛季 常规赛
        season = year+"-"+(Integer.parseInt(year)+1)+"赛季";
        season = season+" ";
        season = season + (("1".equals(type))?"常规赛":"季后赛");
        Iterator<TeamPlayer> iterator = teamPlayerList.iterator();

        while (iterator.hasNext()){
            TeamPlayer t = iterator.next();
            if(StringUtils.isEmpty(t.getPlayer_id())){
                iterator.remove();
                continue;
            }
            Player player = playerService.getByUrlLike(t.getPlayer_id());
            t.setPlayer_id(player.getId());
            t.setTeam_id(teamService.getByUrlLike(bean.getTeamCode()).getId());
            t.setSeason(season);
        }

        teamPlayerService.insertList(teamPlayerList);


    }
}
