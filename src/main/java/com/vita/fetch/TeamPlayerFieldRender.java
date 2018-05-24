package com.vita.fetch;

import com.geccocrawler.gecco.annotation.FieldRenderName;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.response.HttpResponse;
import com.geccocrawler.gecco.spider.SpiderBean;
import com.geccocrawler.gecco.spider.render.CustomFieldRender;
import com.vita.entity.TeamPlayer;
import net.sf.cglib.beans.BeanMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobo on 2018/5/24.
 *
 * @email ruantianbo@163.com
 */
@FieldRenderName("teamPlayerFieldRender")
public class TeamPlayerFieldRender implements CustomFieldRender {

    @Override
    public void render(HttpRequest request, HttpResponse response, BeanMap beanMap, SpiderBean bean, Field field) {
        Document doc = Jsoup.parse(response.getContent().replace("&nbsp;"," "));
        Elements trs = doc.select("table.stat_box>tbody>tr");
        List<TeamPlayer> teamPlayers = new ArrayList<>();
        for (Element tr: trs){
            TeamPlayer tmp = new TeamPlayer();
            tmp.setPlayer_id(tr.select("td.player_name>a").attr("href"));
            teamPlayers.add(tmp);
        }
        beanMap.put("teamPlayers",teamPlayers);
    }
}
