package com.vita.entity;

/**
 * Created by bobo on 2018/5/14.
 *
 * @email ruantianbo@163.com
 */
public class Coach extends Person {
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
}
