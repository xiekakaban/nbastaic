package com.vita.entity;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by bobo on 2018/5/19.
 *
 * @email ruantianbo@163.com
 */
@Table(name="tb_match")
public class Match {

    String id;
    String homeId; //主队
    String visitingId; //客队

    String homeCoachId; //主队教练
    String visitingCoachId; //客队教练

    String season; //赛季, 赛季类型
    Date happenedTime;

    Integer homeScore;
    Integer visitingScore;

    //    {
    //        "home":[18,30,26,31]
    //        "visiting":[30,32,34,20]
    //
    //    }
    String scoreDet;

    String videoDet; //视频摘要,暂无

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHomeId() {
        return homeId;
    }

    public void setHomeId(String homeId) {
        this.homeId = homeId;
    }

    public String getVisitingId() {
        return visitingId;
    }

    public void setVisitingId(String visitingId) {
        this.visitingId = visitingId;
    }

    public String getHomeCoachId() {
        return homeCoachId;
    }

    public void setHomeCoachId(String homeCoachId) {
        this.homeCoachId = homeCoachId;
    }

    public String getVisitingCoachId() {
        return visitingCoachId;
    }

    public void setVisitingCoachId(String visitingCoachId) {
        this.visitingCoachId = visitingCoachId;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Date getHappenedTime() {
        return happenedTime;
    }

    public void setHappenedTime(Date happenedTime) {
        this.happenedTime = happenedTime;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getVisitingScore() {
        return visitingScore;
    }

    public void setVisitingScore(Integer visitingScore) {
        this.visitingScore = visitingScore;
    }

    public String getScoreDet() {
        return scoreDet;
    }

    public void setScoreDet(String scoreDet) {
        this.scoreDet = scoreDet;
    }

    public String getVideoDet() {
        return videoDet;
    }

    public void setVideoDet(String videoDet) {
        this.videoDet = videoDet;
    }
}
