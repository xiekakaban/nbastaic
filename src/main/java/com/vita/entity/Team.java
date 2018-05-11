package com.vita.entity;

import com.vita.util.GenerateId;

import javax.persistence.Table;

/**
 * Created by bobo on 2018/5/8.
 *
 * @email ruantianbo@163.com
 */
@Table(name="tb_team")
public class Team {

    private String id;
    private String name;
    private String url;
    private Boolean isCurrent;
    private String imgUrl;
    private String position;

    public Team() {
        this.id = GenerateId.generate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
