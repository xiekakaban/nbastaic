package com.vita;

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
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by bobo on 2018/5/8.
 *
 * @email ruantianbo@163.com
 */
@ServletComponentScan
@SpringBootApplication
@ComponentScan({"com.geccocrawler.gecco.spring","com.vita"})
@EnableScheduling
//这里用的是tk的MapperScan
@MapperScan("com.vita.mapper")
public class MainApplication {
    private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args){
        SpringApplication.run(MainApplication.class, args);
    }



//    @Bean
//    public TaskScheduler taskScheduler(){
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        taskScheduler.setPoolSize(10);
//        taskScheduler.setThreadNamePrefix("springboot");
//        return taskScheduler;
//    }
//
//    public static void helpInfo(){
//        System.out.println("****************************************");
//        System.out.println("********1.爬取球员**********************");
//        System.out.println("********2.爬取赛程**********************");
//        System.out.println("********3.*******************************");
//        System.out.println("********4.*******************************");
//        System.out.println("****************************************");
//    }
}
