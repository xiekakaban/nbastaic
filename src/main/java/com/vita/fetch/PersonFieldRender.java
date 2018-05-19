package com.vita.fetch;

import com.geccocrawler.gecco.annotation.FieldRenderName;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.response.HttpResponse;
import com.geccocrawler.gecco.spider.SpiderBean;
import com.geccocrawler.gecco.spider.render.CustomFieldRender;
import com.vita.annotation.FieldText;
import net.sf.cglib.beans.BeanMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * Created by bobo on 2018/5/17.
 *
 * @email ruantianbo@163.com
 */
@FieldRenderName("personFieldRender")
public class PersonFieldRender implements CustomFieldRender {

    private static final Logger logger = LoggerFactory.getLogger(PersonFieldRender.class);

    @Override
    public void render(HttpRequest request, HttpResponse response, BeanMap beanMap, SpiderBean bean, Field field) {
        FieldText text = field.getAnnotation(FieldText.class);
        String fetchKeyWorld = text.value();
        Document doc = Jsoup.parse(response.getContent().replace("&nbsp;"," "));
        Elements fieldRowEles = doc.select("div.detail>div.row>.column:containsOwn("+fetchKeyWorld+")");
        if(fieldRowEles.size()!=1){
            logger.debug(String.format("关键字有误:%s",fetchKeyWorld));
            beanMap.put(field.getName(),"暂无信息");
            return ;
        }
        Element fieldRowEle = fieldRowEles.first();
        beanMap.put(field.getName(),fieldRowEle.parent().ownText());
    }
}
