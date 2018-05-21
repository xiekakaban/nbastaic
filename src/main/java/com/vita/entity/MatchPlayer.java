package com.vita.entity;

/**
 * Created by bobo on 2018/5/19.
 *
 * @email ruantianbo@163.com
 */
public class MatchPlayer extends MatchDetail{


    private String playerId;
    private String teamId;
    private String matchId;

    private Integer sf; //首发
    private Integer sj; //上场时间



    public MatchPlayer() {
    }


    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Integer getSf() {
        return sf;
    }

    public void setSf(Integer sf) {
        this.sf = sf;
    }

    public Integer getSj() {
        return sj;
    }

    public void setSj(Integer sj) {
        this.sj = sj;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
