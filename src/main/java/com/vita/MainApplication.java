package com.vita;

import com.vita.fetch.MatchFetch;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Created by bobo on 2018/5/8.
 *
 * @email ruantianbo@163.com
 */
@ServletComponentScan
@SpringBootApplication
@ComponentScan({"com.geccocrawler.gecco.spring","com.vita"})
@EnableScheduling
@MapperScan("com.vita.mapper")
public class MainApplication {
    private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args){
        SpringApplication.run(MainApplication.class, args);
//        if(args.length == 0 || (args.length==1 && !"team".equalsIgnoreCase(args[0]))){
//            helpInfo();
//            System.exit(1);
//        }else{
//            ApplicationContext springContext = new ClassPathXmlApplicationContext("springContext.xml");
//            if("player".equalsIgnoreCase(args[0])){
//                logger.debug("player");
//            } else if("match".equalsIgnoreCase(args[0])){
//                logger.debug("match");
//            }else if("team".equalsIgnoreCase(args[0])) {
//                TeamFetch tf = (TeamFetch)springContext.getBean("teamFetch");
//                tf.start();
//            } else{
//                helpInfo();
//            }
//        }
    }

    @Bean
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.setThreadNamePrefix("springboot");
        return taskScheduler;
    }

    public static void helpInfo(){
        System.out.println("****************************************");
        System.out.println("********1.爬取球员**********************");
        System.out.println("********2.爬取赛程**********************");
        System.out.println("********3.*******************************");
        System.out.println("********4.*******************************");
        System.out.println("****************************************");
    }
}
