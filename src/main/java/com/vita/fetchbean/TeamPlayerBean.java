package com.vita.fetchbean;

import com.geccocrawler.gecco.annotation.FieldRenderName;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.vita.entity.TeamPlayer;

import java.util.List;

/**
 * Created by bobo on 2018/5/24.
 *
 * @email ruantianbo@163.com
 */
@Gecco(matchUrl = "http://www.stat-nba.com/team/stat_box_team.php?team={teamCode}&season={season}&col=pts&order=1&isseason={isseason}", pipelines = "teamPlayerPipeline")
public class TeamPlayerBean implements HtmlBean {

    @Request
    @FieldRenderName("teamPlayerFieldRender")
    private HttpRequest request;

    private List<TeamPlayer> teamPlayers;

    @RequestParameter
    private String teamCode;

    public TeamPlayerBean() {

    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<TeamPlayer> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(List<TeamPlayer> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }
}
