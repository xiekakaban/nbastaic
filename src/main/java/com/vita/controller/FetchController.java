package com.vita.controller;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spring.SpringPipelineFactory;
import com.vita.util.SpringUtil;
import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobo on 2018/5/10.
 *
 * @email ruantianbo@163.com
 */
@Controller
@RequestMapping("/fetch")
public class FetchController {

    private static final String TEAMBASHURL = "http://www.stat-nba.com/playerList.php?il=";
    private static final String MATCHBASEURL = "http://www.stat-nba.com/gameList_simple-";//http://www.stat-nba.com/gameList_simple-2017-05.html
    @GetMapping("/team")
    @ResponseBody
    public ResponseEntity<String> fetchTeam(){
        SpringPipelineFactory springPipelineFactory = SpringUtil.getBean("springPipelineFactory");
        HttpGetRequest start = new HttpGetRequest("http://www.stat-nba.com/teamList.php");
        start.setCharset("UTF-8");
        GeccoEngine.create()
                .pipelineFactory(springPipelineFactory)
                .classpath("com.vita")
                .start(start)
                .loop(false)
                .run();
        return new ResponseEntity("works fine",HttpStatus.OK);
    }

    @GetMapping("/player")
    @ResponseBody
    public ResponseEntity<String> fetchPlayer(){
        List<HttpRequest> fetchUrl = new ArrayList<>();
        for(int i='Z';i<='Z';i++){
            fetchUrl.add(new HttpGetRequest(TEAMBASHURL+(char)i));
        }
        SpringPipelineFactory springPipelineFactory = SpringUtil.getBean("springPipelineFactory");
        GeccoEngine.create()
                .pipelineFactory(springPipelineFactory)
                .classpath("com.vita")
                .start(fetchUrl)
                .loop(false)
                .thread(10)
                .run();
        return new ResponseEntity("fetch Team works fine",HttpStatus.OK);
    }

    @GetMapping("/match")
    @ResponseBody
    public ResponseEntity<String> fetchMatch(){
        int[] years = new int[]{2017};
        List<HttpRequest> fetchUrl = new ArrayList<>();
        for(int year : years){
            for(int i=1;i<=12;i++){
                fetchUrl.add(new HttpGetRequest(MATCHBASEURL+year+"-"+i+".html"));
            }
        }
        SpringPipelineFactory springPipelineFactory = SpringUtil.getBean("springPipelineFactory");
        GeccoEngine.create()
                .pipelineFactory(springPipelineFactory)
                .classpath("com.vita")
                .start(fetchUrl)
                .loop(false)
                .thread(10)
                .run();
        return new ResponseEntity("fetch Match works fine",HttpStatus.OK);
    }


    public static void main(String[] args){
        HttpGetRequest start = new HttpGetRequest("http://www.baidu.com/");
        start.setCharset("GBK");
        GeccoEngine.create()
                .classpath("com.vita")
                .start(start)
                .loop(false)
                .run();
    }
}
