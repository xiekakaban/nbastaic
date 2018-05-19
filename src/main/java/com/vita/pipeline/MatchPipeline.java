package com.vita.pipeline;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.vita.fetchbean.MatchAssociationHtmlBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by bobo on 2018/5/19.
 *
 * @email ruantianbo@163.com
 */
@Service("matchPipeline")
@PipelineName("matchPipeline")
public class MatchPipeline implements Pipeline<MatchAssociationHtmlBean> {

    private static final Logger logger = LoggerFactory.getLogger(MatchPipeline.class);
    @Override
    public void process(MatchAssociationHtmlBean bean) {
        logger.debug(JSON.toJSONString(bean));
    }
}
