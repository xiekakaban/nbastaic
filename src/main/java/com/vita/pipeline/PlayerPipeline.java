package com.vita.pipeline;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.vita.entity.Coach;
import com.vita.entity.Player;
import com.vita.fetchbean.CoachBean;
import com.vita.fetchbean.PlayerBean;
import com.vita.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bobo on 2018/5/17.
 *
 * @email ruantianbo@163.com
 */
@Service("playerPipeline")
@PipelineName("playerPipeline")
public class PlayerPipeline implements Pipeline<PlayerBean> {
    private static final Logger logger = LoggerFactory.getLogger(PlayerPipeline.class);


    @Autowired
    private PlayerService playerService;

    @Override
    public void process(PlayerBean bean) {

        String url = bean.getRequest().getUrl();
        bean.setUrl(url.substring(0,url.lastIndexOf("?")));
        Player palyer = new Player().generateFromPlayerBean(bean);

        playerService.insert(palyer);
    }
}
