package com.vita.fetch;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.FieldRenderName;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.response.HttpResponse;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.geccocrawler.gecco.spider.SpiderBean;
import com.geccocrawler.gecco.spider.render.CustomFieldRender;
import com.vita.entity.*;
import com.vita.service.CoachService;
import com.vita.service.PlayerService;
import com.vita.service.TeamService;
import net.sf.cglib.beans.BeanMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bobo on 2018/5/20.
 *
 * @email ruantianbo@163.com
 */
@Component
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
        String requestUrl = request.getUrl();
        m.setId(requestUrl.substring(requestUrl.lastIndexOf("/")+1,requestUrl.length()-5));
        m.setSeason(doc.select("div[style='margin-top:10px;']").first().ownText());

        String DateStr = doc.select("div[style='float: left;margin-top: 25px;margin-left: 10px;font-size: 16px;font-weight: bold;color: #009CFF']").first().ownText();
        try{
            m.setHappenedTime(sdf.parse(DateStr));
        }catch (Exception ex){
            logger.error("error while formate match happendTime for: "+request.getUrl());
        }
//        String visitingUrl = doc.select(".basic>.team").get(0).select(".teamDiv>a[href^=/team]").first().attr("href");
//        String homeUrl = doc.select(".basic>.team").get(1).select(".teamDiv>a[href^=/team]").first().attr("href");
//        Team homeTeam = teamService.getByUrl(homeUrl);
//        Team visitingTeam = teamService.getByUrl(visitingUrl);
//
//        if(homeTeam == null){
//            DeriveSchedulerContext.into(request.subRequest(homeUrl));
//            DeriveSchedulerContext.into(request);
//            return ; //it will fetch again
//        }
//        if(visitingTeam == null){
//            DeriveSchedulerContext.into(request.subRequest(visitingUrl));
//            DeriveSchedulerContext.into(request);
//            return ;
//        }

        m.setVisitingId(doc.select(".basic>.team").get(0).select(".teamDiv>a[href^=/team]").first().attr("href"));
        m.setHomeId(doc.select(".basic>.team").get(1).select(".teamDiv>a[href^=/team]").first().attr("href"));
        m.setHomeScore(Integer.parseInt(doc.select(".basic>.scorebox>.text>.score").get(1).ownText()));
        m.setVisitingScore(Integer.parseInt(doc.select(".basic>.scorebox>.text>.score").get(0).ownText()));

//        String visitingCoachuUrl = doc.select(".detail a[href^='/coach']").get(0).attr("href");
//        String homeCoachUrl = doc.select(".detail a[href^='/coach']").get(1).attr("href");
//        Coach visitingCoach = coachService.getByUrl(visitingCoachuUrl);
//        Coach homeCoach = coachService.getByUrl(homeCoachUrl);
//        if(homeCoach == null){
//            DeriveSchedulerContext.into(request.subRequest(homeUrl));
//            DeriveSchedulerContext.into(request);
//            return ; //it will fetch again
//        }
//        if(visitingCoach == null){
//            DeriveSchedulerContext.into(request.subRequest(visitingUrl));
//            DeriveSchedulerContext.into(request);
//            return ;
//        }

        m.setHomeCoachId(doc.select(".detail a[href^='/coach']").get(1).attr("href"));
        m.setVisitingCoachId(doc.select(".detail a[href^='/coach']").get(0).attr("href"));

        Map<String,List<String>> scoresMap = new HashMap<>();
        Elements homeTds = doc.select(".basic>.scorebox>.table").get(1).select("tbody>tr>td.number");
        Elements visitingTds = doc.select(".basic>.scorebox>.table").get(0).select("tbody>tr>td.number");
        List<String> homeScoreList = new ArrayList<>();
        List<String> visitingScoreList = new ArrayList<>();
        for(Element td: homeTds){
            homeScoreList.add(td.ownText());
        }
        for(Element td: visitingTds){
            visitingScoreList.add(td.ownText());
        }
        scoresMap.put("home",homeScoreList);
        scoresMap.put("visiting",visitingScoreList);

        m.setScoreDet(JSON.toJSONString(scoresMap));
        beanMap.put("matche",m);
        // end Match


        List<MatchPlayer> matchPlayers = new ArrayList<>();
        Elements visitingMatchPlayerTrs = doc.select(".detail>div.stat_box").get(0).select("table.stat_box>tbody>tr.sort");
        beanMap.put("matchVisitingPlayers",initMatchPlayer(visitingMatchPlayerTrs,m,Boolean.TRUE));
        Elements homeMatchPlayerTrs = doc.select(".detail>div.stat_box").get(1).select("table.stat_box>tbody>tr.sort");
        beanMap.put("matchHomePlayers",initMatchPlayer(homeMatchPlayerTrs,m,Boolean.FALSE));
//        Player pTemp;
//        for(MatchPlayer mp : matchPlayers){
//            pTemp = playerService.getByUrl(mp.getPlayerId());
//            if (pTemp == null){
//                DeriveSchedulerContext.into(request.subRequest(mp.getPlayerId()));
//                DeriveSchedulerContext.into(request);
//                return;
//            }else{
//                mp.setPlayerId(pTemp.getId());
//            }
//        }
        beanMap.put("matchPlayers",matchPlayers);

        // end MatchPlayer


        Element visitingTeamDet = doc.select(".detail>div.stat_box").get(0).select("table.stat_box>tbody>tr.team_all_content").first();
        Element homeTeamDet = doc.select(".detail>div.stat_box").get(1).select("table.stat_box>tbody>tr.team_all_content").first();
        beanMap.put("homeTeam",initMatchTeam(homeTeamDet,m,Boolean.FALSE));
        beanMap.put("visitingTeam",initMatchTeam(homeTeamDet,m,Boolean.TRUE));
        logger.debug(beanMap.toString());
    }

    private MatchTeam initMatchTeam(Element e,Match m,Boolean isVisiting){
        MatchTeam matchTeam = new MatchTeam();
        matchTeam.setMatchId(m.getId());
        matchTeam.setTeamId(isVisiting?m.getVisitingId():m.getHomeId());
        matchTeam.setCc(getIntExceptNull((e.select("td.player_id").first().ownText()).replace("人","")));
        matchTeam.setTl(getDoubleExceptNull(e.select("td.fgper").first().ownText().replace("%","")) / 100);
        matchTeam.setMz(getIntExceptNull(e.select("td.fg").first().ownText()));
        matchTeam.setCs(getIntExceptNull(e.select("td.fga").first().ownText()));

        matchTeam.setSanfen(getDoubleExceptNull(e.select("td.threepper").first().ownText().replace("%","")) / 100);
        matchTeam.setSanfenmz(getIntExceptNull(e.select("td.threep").first().ownText()));
        matchTeam.setSanfencs(getIntExceptNull(e.select("td.threepa").first().ownText()));

        matchTeam.setFq(getDoubleExceptNull(e.select("td.ftper").first().ownText().replace("%","")) / 100);
        matchTeam.setFqmz(getIntExceptNull(e.select("td.ft").first().ownText()));
        matchTeam.setFqcs(getIntExceptNull(e.select("td.fta").first().ownText()));

        matchTeam.setZsmz(getDoubleExceptNull(e.select("td.ts").first().ownText().replace("%","")) / 100);
        matchTeam.setLb(getIntExceptNull(e.select("td.trb").first().ownText()));
        matchTeam.setQc(getIntExceptNull(e.select("td.orb").first().ownText()));
        matchTeam.setHc(getIntExceptNull(e.select("td.drb").first().ownText()));
        matchTeam.setZg(getIntExceptNull(e.select("td.ast").first().ownText()));
        matchTeam.setQd(getIntExceptNull(e.select("td.stl").first().ownText()));
        matchTeam.setGm(getIntExceptNull(e.select("td.blk").first().ownText()));
        matchTeam.setSw(getIntExceptNull(e.select("td.tov").first().ownText()));
        matchTeam.setFg(getIntExceptNull(e.select("td.pf").first().ownText()));
        matchTeam.setDf(getIntExceptNull(e.select("td.pts").first().ownText()));

        return matchTeam;
    }

    private List<MatchPlayer> initMatchPlayer(Elements trs,Match m, Boolean isVisiting){
        List<MatchPlayer> result = new ArrayList<>();
        for(Element tr: trs){
            MatchPlayer mPlayer = new MatchPlayer();

            // here is playerUrl
            mPlayer.setPlayerId(tr.select("td.player_name_out>a").first().attr("href"));
            mPlayer.setMatchId(m.getId());
            mPlayer.setTeamId(isVisiting?m.getVisitingId():m.getHomeId());
            mPlayer.setSf(getIntExceptNull(tr.select("td.gs").first().attr("rank")));
            mPlayer.setSj(getIntExceptNull(tr.select("td.mp").first().attr("rank")));
            mPlayer.setTl(getDoubleExceptNull(tr.select("td.fgper").first().attr("rank")));
            mPlayer.setMz(getIntExceptNull(tr.select("td.fg").first().attr("rank")));
            mPlayer.setCs(getIntExceptNull(tr.select("td.fga").first().attr("rank")));
            mPlayer.setSanfen(getDoubleExceptNull(tr.select("td.threepper").first().attr("rank")));
            mPlayer.setSanfenmz(getIntExceptNull(tr.select("td.threep").first().attr("rank")));
            mPlayer.setSanfencs(getIntExceptNull(tr.select("td.threepa").first().attr("rank")));

            mPlayer.setFq(getDoubleExceptNull(tr.select("td.ftper").first().attr("rank")));
            mPlayer.setFqmz(getIntExceptNull(tr.select("td.ft").first().attr("rank")));
            mPlayer.setFqcs(getIntExceptNull(tr.select("td.fta").first().attr("rank")));

            mPlayer.setZsmz(getDoubleExceptNull(tr.select("td.ts").first().attr("rank")));
            mPlayer.setLb(getIntExceptNull(tr.select("td.trb").first().attr("rank")));
            mPlayer.setQc(getIntExceptNull(tr.select("td.orb").first().attr("rank")));
            mPlayer.setHc(getIntExceptNull(tr.select("td.drb").first().attr("rank")));
            mPlayer.setZg(getIntExceptNull(tr.select("td.ast").first().attr("rank")));
            mPlayer.setQd(getIntExceptNull(tr.select("td.stl").first().attr("rank")));
            mPlayer.setGm(getIntExceptNull(tr.select("td.blk").first().attr("rank")));
            mPlayer.setSw(getIntExceptNull(tr.select("td.tov").first().attr("rank")));
            mPlayer.setFg(getIntExceptNull(tr.select("td.pf").first().attr("rank")));
            mPlayer.setDf(getIntExceptNull(tr.select("td.pts").first().attr("rank")));
            result.add(mPlayer);
        }
        return result;
    }


    private Integer getIntExceptNull(String d){
        try {
            if (d == null) {
                return 0;
            } else{
                return Integer.parseInt(d);
            }
        }catch (NumberFormatException e){
            return 0;
        }
    }

    private Double getDoubleExceptNull(String d){
        try {
            if (d == null) {
                return 0.0;
            } else{
                return Double.parseDouble(d);
            }
        }catch (NumberFormatException e){
            return 0.0;
        }
    }

//    private Number getExceptNull(String d,Class clz){
//        Boolean isTransferDouble = (clz == Double.class) ? Boolean.TRUE : Boolean.FALSE;
//        try {
//            if (d == null) {
//                return isTransferDouble?0.0:0;
//            } else {
//                return isTransferDouble?Double.parseDouble(d):Integer.parseInt(d);
//            }
//        }catch (NumberFormatException e){
//            return isTransferDouble?0.0:0;
//        }
//    }
}
