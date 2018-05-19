package com.vita.fetchbean;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.vita.annotation.FieldText;

import java.util.Date;

/**
 * Created by bobo on 2018/5/17.
 *
 * @email ruantianbo@163.com
 */
@Gecco(matchUrl = "http://www.stat-nba.com/coach/{coachNum}.html?capital={capital}",pipelines = {"coachPipeline"})
public class CoachBean implements HtmlBean{

    @Request
    private HttpRequest request;

    @RequestParameter("coachNum")
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

    @FieldText("执教生涯:")
    @FieldRenderName("personFieldRender")
    String teach; //执教生涯

    @FieldText("常 规 赛:")
    @FieldRenderName("personFieldRender")
    String regular;

    @FieldText("季 后 赛:")
    @FieldRenderName("personFieldRender")
    String playoff;

    @FieldText("总 决 赛:")
    @FieldRenderName("personFieldRender")
    String finalMatch;

    @FieldText("总 冠 军:")
    @FieldRenderName("personFieldRender")
    String chimpion;

    @FieldText("最佳教练:")
    @FieldRenderName("personFieldRender")
    String bestCoach;

    String url;

    public CoachBean() {
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

    public String getBestCoach() {
        return bestCoach;
    }

    public void setBestCoach(String bestCoach) {
        this.bestCoach = bestCoach;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
