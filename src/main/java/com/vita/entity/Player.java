package com.vita.entity;

/**
 * Created by bobo on 2018/5/14.
 *
 * @email ruantianbo@163.com
 */
public class Player extends Person{

    String position;
    Integer height;
    Integer weight;
    String cloth; //球衣号码
    String talentShow; //选秀

    public Player() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCloth() {
        return cloth;
    }

    public void setCloth(String cloth) {
        this.cloth = cloth;
    }

    public String getTalentShow() {
        return talentShow;
    }

    public void setTalentShow(String talentShow) {
        this.talentShow = talentShow;
    }
}
