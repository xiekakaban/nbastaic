package com.vita.entity;

import com.vita.fetchbean.PlayerBean;
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
@Table(name="tb_person")
public class Player extends Person{
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
    private static final Logger logger = LoggerFactory.getLogger(Player.class);


    String position;
    Double height;
    Integer weight;
    String cloth; //球衣号码
    String talentShow; //选秀
    String ctype = "P";

    public Player() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
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

    public Player generateFromPlayerBean(PlayerBean playerBean){
        this.id = playerBean.getId();
        String[] names = playerBean.getNameCombine().split("/");
        if(names.length == 2){
            this.cName = names[0];
            this.eName = names[1];
        } else{
            this.cName = names[0];
            this.eName = names[0];
        }

        this.capital = playerBean.getCapital();
        try {
            this.birthday = dateFormat.parse(playerBean.getBirthday());
        } catch (ParseException e) {
            logger.error("Date format error for Coach",e);
        }
        this.location = playerBean.getLocation();
        this.highSchool = playerBean.getHighSchool();
        this.university = playerBean.getUniversity();
        this.url = playerBean.getUrl();
        this.position = playerBean.getPosition();

        this.height  = Double.parseDouble(playerBean.getHeight().split("米")[0]);
        this.weight = Integer.parseInt(playerBean.getWeight().split("公斤")[0]);
        this.cloth = playerBean.getCloth(); //球衣号码
        this.talentShow = playerBean.getTalentShow(); //选秀

        return this;
    }
}
