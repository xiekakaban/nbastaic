package com.vita.fetchbean;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * Created by bobo on 2018/5/14.
 *
 * @email ruantianbo@163.com
 */
@Gecco(matchUrl = "http://www.stat-nba.com/playerList.php?il={capital}",pipelines = "personPipeline")
public class PersonBean implements HtmlBean{

    @Request
    HttpRequest request;

    @RequestParameter
    private String capital;

    @Href
    @HtmlField(cssPath = "a[href*=/coach/]")
    List<String> coachUrl;


    @Href
    @HtmlField(cssPath = "a[href*=/player/]")
    List<String> playerUrl;

    public PersonBean() {
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<String> getCoachUrl() {
        return coachUrl;
    }

    public void setCoachUrl(List<String> coachUrl) {
        this.coachUrl = coachUrl;
    }

    public List<String> getPlayerUrl() {
        return playerUrl;
    }

    public void setPlayerUrl(List<String> playerUrl) {
        this.playerUrl = playerUrl;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
