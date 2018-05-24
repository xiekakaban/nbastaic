package com.vita.pipeline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.vita.entity.Team;
import com.vita.fetchbean.TeamBean;
import com.vita.service.TeamService;
import com.vita.util.GenerateId;
import org.apache.http.util.Asserts;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobo on 2018/5/8.
 *
 * @email ruantianbo@163.com
 */
@Service("teamPipeline")
@PipelineName("teamPipeline")
public class TeamPipeline implements Pipeline<TeamBean>,ApplicationContextAware{

    private static final Logger logger = LoggerFactory.getLogger(TeamPipeline.class);
    private ApplicationContext applicationContext;

    @Autowired
    @Qualifier("teamService")
    private TeamService teamService;


    @Override
    public void process(TeamBean bean) {
        List<Team> teamList = new ArrayList<Team>();
        Document curTeamDoc = Jsoup.parse(bean.getCurrentTeams());
        Elements tdEle = curTeamDoc.select("table td");
        Asserts.check(tdEle.size()==6,"size not compare");
        String pos = "";
        for(int i=0;i<6;i++){
            if(i<3){
                pos = "东部";
            }else{
                pos = "西部";
            }
            Elements teamsEle = tdEle.get(i).select("div.team");
            for(Element teamItem : teamsEle){
                teamList.add(generateTeam(teamItem,pos,true));
            }
        }
        System.out.println(teamService != null);
        Document hisTeamDoc = Jsoup.parse(bean.getHistoryTeams());
        Elements hisTeamEle = hisTeamDoc.select("div.team");
        for(Element teamItem : hisTeamEle){
            teamList.add(generateTeam(teamItem,"已退役",false));
        }

        for(Team item : teamList){
            teamService.insert(item);
        }

        logger.debug(JSON.toJSONString(teamList,true));

    }

    private Team generateTeam(Element teamItem,String pos,Boolean isCurrent){
        Team t = new Team();
        t.setUrl("http://www.stat-nba.com"+teamItem.getElementsByTag("a").get(0).attr("href").substring(1));
        t.setName(teamItem.select("a div").get(0).text());
        t.setImgUrl("http://www.stat-nba.com"+teamItem.select("a>img").get(0).attr("src"));
        t.setPosition(pos);
        t.setIsCurrent(isCurrent);
        return t;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
