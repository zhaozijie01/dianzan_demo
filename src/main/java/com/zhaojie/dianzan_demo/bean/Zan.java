package com.zhaojie.dianzan_demo.bean;

import org.beetl.sql.core.annotatoin.Table;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Table(name="zan")
public class Zan implements Serializable {

    Integer id;
    String name;
    String title;
    Integer zan;

    @Override
    public String toString() {
        return "Zan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", zan=" + zan +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }
}
