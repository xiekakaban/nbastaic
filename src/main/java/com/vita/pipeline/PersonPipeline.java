package com.vita.pipeline;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import com.vita.fetchbean.PersonBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by bobo on 2018/5/15.
 *
 * @email ruantianbo@163.com
 */
@Service("personPipeline")
@PipelineName("personPipeline")
public class PersonPipeline implements Pipeline<PersonBean>{
    private static final Logger logger = LoggerFactory.getLogger(PersonPipeline.class);
    @Override
    public void process(PersonBean bean) {
//        logger.debug(JSON.toJSONString(bean.getPlayerUrl()));
//        logger.debug(JSON.toJSONString(bean.getCoachUrl()));
        for(String item: bean.getPlayerUrl()) {
            DeriveSchedulerContext.into(bean.getRequest().subRequest(item+"?capital="+bean.getCapital()));
        }
        for(String item: bean.getCoachUrl()){
            DeriveSchedulerContext.into(bean.getRequest().subRequest(item+"?capital="+bean.getCapital()));
        }

    }
}
