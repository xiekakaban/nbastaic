package com.vita.pipeline;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.vita.entity.Coach;
import com.vita.fetchbean.CoachBean;
import com.vita.service.CoachService;
import com.vita.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by bobo on 2018/5/17.
 *
 * @email ruantianbo@163.com
 */
@Service("coachPipeline")
@PipelineName("coachPipeline")
public class CoachPipeline implements Pipeline<CoachBean> {
    private static final Logger logger = LoggerFactory.getLogger(CoachPipeline.class);


    @Autowired
    private CoachService coachService;

    @Override
    public void process(CoachBean bean) {
//        logger.debug(JSON.toJSONString(bean));
        String url = bean.getRequest().getUrl();
        bean.setUrl(url.substring(0,url.lastIndexOf("?")));
        Coach coach = new Coach().generateFromCoachBean(bean);
        coachService.insert(coach);
    }
}
