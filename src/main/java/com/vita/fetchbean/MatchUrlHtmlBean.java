package com.vita.fetchbean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * Created by bobo on 2018/5/19.
 *
 * @email ruantianbo@163.com
 */
@Gecco(matchUrl = "http://www.stat-nba.com/gameList_simple-{year}-{month}.html")
public class MatchUrlHtmlBean implements HtmlBean{

    @Request
    private HttpRequest request;

    @Href(click = true)
    @HtmlField(cssPath = "a[href^=game]")
    private List<String> fetchUrl;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<String> getFetchUrl() {
        return fetchUrl;
    }

    public void setFetchUrl(List<String> fetchUrl) {
        this.fetchUrl = fetchUrl;
    }
}
