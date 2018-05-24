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

    private List<MatchPlayer> matchHomePlayers;

    private List<MatchPlayer> matchVisitingPlayers;

    private MatchTeam homeTeam;

    private MatchTeam visitingTeam;

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

    public List<MatchPlayer> getMatchHomePlayers() {
        return matchHomePlayers;
    }

    public void setMatchHomePlayers(List<MatchPlayer> matchHomePlayers) {
        this.matchHomePlayers = matchHomePlayers;
    }

    public List<MatchPlayer> getMatchVisitingPlayers() {
        return matchVisitingPlayers;
    }

    public void setMatchVisitingPlayers(List<MatchPlayer> matchVisitingPlayers) {
        this.matchVisitingPlayers = matchVisitingPlayers;
    }

    public MatchTeam getVisitingTeam() {
        return visitingTeam;
    }

    public void setVisitingTeam(MatchTeam visitingTeam) {
        this.visitingTeam = visitingTeam;
    }

    public MatchTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(MatchTeam homeTeam) {
        this.homeTeam = homeTeam;
    }
}
