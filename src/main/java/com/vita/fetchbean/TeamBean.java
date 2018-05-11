package com.vita.fetchbean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Html;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by bobo on 2018/5/8.
 *
 * @email ruantianbo@163.com
 */
@Gecco(matchUrl = "http://www.stat-nba.com/teamList.php",pipelines = "teamPipeline")
public class TeamBean implements HtmlBean{

    @Request
    private HttpRequest request;

    @HtmlField(cssPath = "div.stat_box")
    private String currentTeams;

    @HtmlField(cssPath = "div.teamList")
    private String historyTeams;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public String getCurrentTeams() {
        return currentTeams;
    }

    public void setCurrentTeams(String currentTeams) {
        this.currentTeams = currentTeams;
    }

    public String getHistoryTeams() {
        return historyTeams;
    }

    public void setHistoryTeams(String historyTeams) {
        this.historyTeams = historyTeams;
    }
}
