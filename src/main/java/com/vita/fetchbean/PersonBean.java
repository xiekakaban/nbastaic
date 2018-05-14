package com.vita.fetchbean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Request;

/**
 * Created by bobo on 2018/5/14.
 *
 * @email ruantianbo@163.com
 */
@Gecco(matchUrl = "http://www.stat-nba.com/playerList.php?il=(A-Z){capital}",pipelines = "PersonPipeline")
public class PersonBean {

    Request request;

}
