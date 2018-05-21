package com.vita.pipeline;

import com.alibaba.fastjson.JSON;
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
        if(validMatch(bean).size() == 0){
            //works fine
            matchService.insert(bean.getMatche());
            matchPlayerService.insertList(bean.getMatchPlayers());
            matchTeamService.insertList(bean.getMatchTeams());
        } else{
            for(HttpRequest failurRequest : willReFetchs){
                logger.warn("will fetch again: " + failurRequest.getUrl());
            }
        }
    }

    private List<HttpRequest> validMatch(MatchAssociationHtmlBean bean){
        List<HttpRequest> failureRequest = new ArrayList<>();
        HttpRequest request =  bean.getRequest();
        String visitingUrl = bean.getMatche().getVisitingId();
        String homeUrl = bean.getMatche().getHomeId();
        Team homeTeam = teamService.getByUrlLike("."+homeUrl);
        Team visitingTeam = teamService.getByUrlLike("."+visitingUrl);

        if(homeTeam == null){
            failureRequest.add(request.subRequest(homeUrl));
        } else{
            bean.getMatche().setHomeId(homeTeam.getId());
        }
        if(visitingTeam == null){
            failureRequest.add(request.subRequest(visitingUrl));
        }else{
            bean.getMatche().setVisitingId(visitingTeam.getId());
        }

        String visitingCoachuUrl = bean.getMatche().getVisithingCoachId();
        String homeCoachUrl = bean.getMatche().getHomeCoachId();
        Coach visitingCoach = coachService.getByUrlLike(visitingCoachuUrl);
        Coach homeCoach = coachService.getByUrlLike(homeCoachUrl);
        if(homeCoach == null){
            failureRequest.add(request.subRequest(homeCoachUrl));
        } else{
            bean.getMatche().setHomeCoachId(homeCoach.getId());
        }
        if(visitingCoach == null){
            failureRequest.add(request.subRequest(visitingCoachuUrl));
        } else{
            bean.getMatche().setVisithingCoachId(visitingCoach.getId());
        }

        Player pTemp;
        for(MatchPlayer mp : bean.getMatchPlayers()){
            pTemp = playerService.getByUrlLike(mp.getPlayerId());
            if (pTemp == null){
                failureRequest.add(request.subRequest(mp.getPlayerId()));
            }else{
                mp.setPlayerId(pTemp.getId());
            }
        }

        return failureRequest;
    }

}
