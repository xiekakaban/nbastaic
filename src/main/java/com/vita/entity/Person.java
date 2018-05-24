package com.vita.entity;

import com.vita.fetchbean.PersonBean;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by bobo on 2018/5/14.
 *
 * @email ruantianbo@163.com
 */
public abstract class Person {

    String id;
    String cName; //中文名
    String eName; //英文名
    String capital; // 首字母
    Date birthday;
    String location;
    String highSchool;
    String university;
    String url;



    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }


}
