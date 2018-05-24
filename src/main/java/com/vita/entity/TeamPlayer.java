package com.vita.entity;

import com.vita.util.GenerateId;

import javax.persistence.Table;

/**
 * Created by bobo on 2018/5/24.
 *
 * @email ruantianbo@163.com
 */
@Table(name="tb_team_p")
public class TeamPlayer {
    private String id;
    private String team_id;
    private String player_id;
    private String season; // 14-15赛季 常规赛

    public TeamPlayer() {
        this.id = GenerateId.generate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
