package com.vita.entity;

/**
 * Created by bobo on 2018/5/19.
 *
 * @email ruantianbo@163.com
 */
public class MatchTeam extends MatchDetail{



    private String matchId;
    private String teamId;

    private Integer cc;  //出场

    public MatchTeam() {
    }


    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }
}
