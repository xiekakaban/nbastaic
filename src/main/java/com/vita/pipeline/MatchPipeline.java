package com.vita.pipeline;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import com.vita.entity.*;
import com.vita.fetchbean.MatchAssociationHtmlBean;
import com.vita.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobo on 2018/5/19.
 *
 * @email ruantianbo@163.com
 */
@Service("matchPipeline")
@PipelineName("matchPipeline")
public class MatchPipeline implements Pipeline<MatchAssociationHtmlBean> {

    private static final Logger logger = LoggerFactory.getLogger(MatchPipeline.class);


    @Autowired
    @Qualifier("playerService")
    private PlayerService playerService;

    @Autowired
    @Qualifier("coachService")
    private CoachService coachService;

    @Autowired
    @Qualifier("teamService")
    private TeamService teamService;

    @Autowired
    private MatchService matchService;

    @Autowired
    private MatchPlayerService matchPlayerService;

    @Autowired
    private MatchTeamService matchTeamService;



    @Override
    @Transactional
    public void process(MatchAssociationHtmlBean bean) {
        List<HttpRequest> willReFetchs = validMatch(bean);
        if(willReFetchs.size() == 0){
            //works fine
            matchService.insert(bean.getMatche());
            matchPlayerService.insertList(bean.getMatchHomePlayers());
            matchPlayerService.insertList(bean.getMatchVisitingPlayers());
            matchTeamService.insert(bean.getHomeTeam());
            matchTeamService.insert(bean.getVisitingTeam());
        } else{
            for(HttpRequest failurRequest : willReFetchs){
                DeriveSchedulerContext.into(failurRequest);
                logger.warn("will fetch again: " + failurRequest.getUrl());
            }
        }
    }

    private List<HttpRequest> validMatch(MatchAssociationHtmlBean bean) {
        try {
            List<HttpRequest> failureRequest = new ArrayList<>();
            HttpRequest request = bean.getRequest();
            String visitingUrl = bean.getMatche().getVisitingId();
            String homeUrl = bean.getMatche().getHomeId();
            Team homeTeam = teamService.getByUrl("http://www.stat-nba.com" + homeUrl);
            Team visitingTeam = teamService.getByUrl("http://www.stat-nba.com" + visitingUrl);

            if (homeTeam == null) {
                logger.warn("error for:" + homeUrl);
                failureRequest.add(request.subRequest("http://www.stat-nba.com" + homeUrl));
                return failureRequest;
            } else {
                bean.getMatche().setHomeId(homeTeam.getId());
                bean.getHomeTeam().setTeamId(homeTeam.getId());
            }
            if (visitingTeam == null) {
                logger.warn("error for:" + visitingUrl);
                failureRequest.add(request.subRequest("http://www.stat-nba.com" + visitingUrl));
                return failureRequest;
            } else {
                bean.getMatche().setVisitingId(visitingTeam.getId());
                bean.getVisitingTeam().setTeamId(visitingTeam.getId());
            }

            String visitingCoachuUrl = bean.getMatche().getVisitingCoachId();
            String homeCoachUrl = bean.getMatche().getHomeCoachId();

            Coach visitingCoach = coachService.getByUrl("http://www.stat-nba.com" + visitingCoachuUrl);
            Coach homeCoach = coachService.getByUrl("http://www.stat-nba.com" + homeCoachUrl);
            if (homeCoach == null) {
                logger.warn("error for:" + homeCoachUrl);
                failureRequest.add(request.subRequest(homeCoachUrl));
            } else {
                bean.getMatche().setHomeCoachId(homeCoach.getId());
            }
            if (visitingCoach == null) {
                logger.warn("error for:" + visitingCoachuUrl);
                failureRequest.add(request.subRequest(visitingCoachuUrl));
            } else {
                bean.getMatche().setVisitingCoachId(visitingCoach.getId());
            }

            Player pTemp;
            for (MatchPlayer mp : bean.getMatchHomePlayers()) {
                pTemp = playerService.getByUrl("http://www.stat-nba.com" + mp.getPlayerId());
                if (pTemp == null) {
                    logger.warn("error for:" + mp.getPlayerId());
                    failureRequest.add(request.subRequest("http://www.stat-nba.com"+mp.getPlayerId()+"?capital=9"));
                } else {
                    mp.setPlayerId(pTemp.getId());
                    mp.setTeamId(homeTeam.getId());
                }
            }

            for (MatchPlayer mp : bean.getMatchVisitingPlayers()) {
                pTemp = playerService.getByUrl("http://www.stat-nba.com" + mp.getPlayerId());
                if (pTemp == null) {
                    logger.warn("error for:" + mp.getPlayerId());
                    failureRequest.add(request.subRequest("http://www.stat-nba.com" + mp.getPlayerId()+"?capital=9"));
                } else {
                    mp.setPlayerId(pTemp.getId());
                    mp.setTeamId(visitingTeam.getId());
                }
            }
            return failureRequest;
        }catch (Exception ex){
            logger.error("error while fetch:"+bean.getRequest().getUrl());
            return new ArrayList<HttpRequest>();
        }
    }


}
