package com.vita.entity;

import com.vita.fetchbean.CoachBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Table;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by bobo on 2018/5/14.
 *
 * @email ruantianbo@163.com
 */
@Table(name="tb_coach")
public class Coach extends Person {
    private static final Logger logger = LoggerFactory.getLogger(Coach.class);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");

    String teach; //执教生涯
    String regular;
    String playoff;
    String finalMatch;
    String chimpion;
    String bestCoach;


    public Coach() {
    }

    public String getTeach() {
        return teach;
    }

    public void setTeach(String teach) {
        this.teach = teach;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getPlayoff() {
        return playoff;
    }

    public void setPlayoff(String playoff) {
        this.playoff = playoff;
    }

    public String getFinalMatch() {
        return finalMatch;
    }

    public void setFinalMatch(String finalMatch) {
        this.finalMatch = finalMatch;
    }

    public String getChimpion() {
        return chimpion;
    }

    public void setChimpion(String chimpion) {
        this.chimpion = chimpion;
    }

    public Coach generateFromCoachBean(CoachBean coachBean){
        this.id = coachBean.getId();
        String[] names = coachBean.getNameCombine().split("/");
        if(names.length == 2){
            this.cName = names[0];
            this.eName = names[1];
        }else{
            this.cName = names[0];
            this.eName = names[0];
        }

        this.capital = eName.substring(0,1).toUpperCase();
        try {
            this.birthday = dateFormat.parse(coachBean.getBirthday());
        } catch (ParseException e) {
            logger.error("Date format error for Coach",e);
        }
        this.location = coachBean.getLocation();
        this.highSchool = coachBean.getHighSchool();
        this.university = coachBean.getUniversity();
        this.url = coachBean.getUrl();
        this.teach = coachBean.getTeach();
        this.regular = coachBean.getRegular();
        this.playoff = coachBean.getPlayoff();
        this.finalMatch = coachBean.getFinalMatch();
        this.chimpion = coachBean.getChimpion();
        this.bestCoach = coachBean.getBestCoach();
        return this;
    }
}
