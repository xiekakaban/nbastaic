package com.vita.fetch;

import com.geccocrawler.gecco.annotation.FieldRenderName;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.response.HttpResponse;
import com.geccocrawler.gecco.spider.SpiderBean;
import com.geccocrawler.gecco.spider.render.CustomFieldRender;
import com.vita.entity.Match;
import net.sf.cglib.beans.BeanMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

/**
 * Created by bobo on 2018/5/20.
 *
 * @email ruantianbo@163.com
 */
@FieldRenderName("matchFieldRender")
public class MatchFieldRender implements CustomFieldRender {
    private static final Logger logger = LoggerFactory.getLogger(MatchFieldRender.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public void render(HttpRequest request, HttpResponse response, BeanMap beanMap, SpiderBean bean, Field field) {
//        Match matche;
//        List<MatchPlayer> matchPlayers;
//        List<MatchTeam> matchTeams;

        Document doc = Jsoup.parse(response.getContent().replace("&nbsp;"," "));
        Match m = new Match();
        m.setSeason(doc.select("div[style='margin-top:10px;']").first().ownText());

        String DateStr = doc.select("div[style='float: left;margin-top: 25px;margin-left: 10px;font-size: 16px;font-weight: bold;color: #009CFF']").first().ownText();
        try{
            m.setHappendTime(sdf.parse(DateStr));
        }catch (Exception ex){
            logger.error("error while formate match happendTime for: "+request.getUrl());
        }

        //here is url, it will fill in  team id until pipeline.
        m.setHomeId(doc.select(".basic>.team").get(0).select(".teamDiv>a[href^=/team]").first().attr("href"));
        m.setHomeId(doc.select(".basic>.team").get(1).select(".teamDiv>a[href^=/team]").first().attr("href"));
        m.setHomeScore(Integer.parseInt(doc.select(".basic>.scorebox>.text>.score").get(1).ownText()));
        m.setVisitingScore(Integer.parseInt(doc.select(".basic>.scorebox>.text>.score").get(0).ownText()));

        beanMap.put("matche",m);
    }
}
