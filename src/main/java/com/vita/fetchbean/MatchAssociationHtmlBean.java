package com.vita.fetchbean;

import com.geccocrawler.gecco.annotation.FieldRenderName;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.vita.entity.Match;
import com.vita.entity.MatchPlayer;
import com.vita.entity.MatchTeam;

import java.util.List;

/**
 * Created by bobo on 2018/5/20.
 *
 * @email ruantianbo@163.com
 */
@Gecco(matchUrl = "http://www.stat-nba.com/game/{matchId}.html",pipelines = {"matchPipeline"})
public class MatchAssociationHtmlBean implements HtmlBean{

    @Request
    @FieldRenderName("matchFieldRender") // it will render all fields
    private HttpRequest request;

    private Match matche;

    private List<MatchPlayer> matchPlayers;

    private List<MatchTeam> matchTeams;

    public MatchAssociationHtmlBean() {

    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public Match getMatche() {
        return matche;
    }

    public void setMatche(Match matche) {
        this.matche = matche;
    }

    public List<MatchPlayer> getMatchPlayers() {
        return matchPlayers;
    }

    public void setMatchPlayers(List<MatchPlayer> matchPlayers) {
        this.matchPlayers = matchPlayers;
    }

    public List<MatchTeam> getMatchTeams() {
        return matchTeams;
    }

    public void setMatchTeams(List<MatchTeam> matchTeams) {
        this.matchTeams = matchTeams;
    }
}
