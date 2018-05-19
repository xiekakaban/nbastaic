package com.vita.fetchbean;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.vita.annotation.FieldText;

/**
 * Created by bobo on 2018/5/17.
 *
 * @email ruantianbo@163.com
 */
@Gecco(matchUrl = "http://www.stat-nba.com/player/{playerNum}.html?capital={capital}",pipelines = {"playerPipeline"})
public class PlayerBean implements HtmlBean {

    @Request
    private HttpRequest request;

    @RequestParameter("playerNum")
    private String id;

    @Text
    @HtmlField(cssPath = "div.name")
    private String nameCombine;


    @RequestParameter("capital")
    private String capital; // 首字母

    @FieldText("出生日期:")
    @FieldRenderName("personFieldRender")
    String birthday;


    @FieldText("出生城市:")
    @FieldRenderName("personFieldRender")
    String location;

    @FieldText("高　　中:")
    @FieldRenderName("personFieldRender")
    String highSchool;

    @FieldText("大　　学:")
    @FieldRenderName("personFieldRender")
    String university;

    @FieldText("位　　置:")
    @FieldRenderName("personFieldRender")
    String position;

    @FieldText("身　　高:")
    @FieldRenderName("personFieldRender")
    String height;

    @FieldText("体　　重:")
    @FieldRenderName("personFieldRender")
    String weight;

    @FieldText("球衣号码:")
    @FieldRenderName("personFieldRender")
    String cloth; //球衣号码

    @FieldText("选秀情况:")
    @FieldRenderName("personFieldRender")
    String talentShow; //选秀

    String url;

    public PlayerBean() {
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCombine() {
        return nameCombine;
    }

    public void setNameCombine(String nameCombine) {
        this.nameCombine = nameCombine;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
