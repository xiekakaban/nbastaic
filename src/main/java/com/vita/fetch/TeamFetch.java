package com.vita.fetch;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.vita.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by bobo on 2018/5/8.
 *
 * @email ruantianbo@163.com
 */
public class TeamFetch {


    private static final String TEAMURL = "http://www.stat-nba.com/teamList.php";
    public TeamFetch() {
    }

    public void start(){
        GeccoEngine.create()
                .classpath("com.vita")
                .start("http://www.stat-nba.com/teamList.php")
                .thread(1)
                .interval(2000)
                .loop(true)
                .mobile(false)
                .run();
    }

}
