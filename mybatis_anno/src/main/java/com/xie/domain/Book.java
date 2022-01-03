package com.xie.domain;

import java.util.Date;
import java.util.List;

public class Book {
    private int id;
    private String btitle;
    private Date bpubDate;

    // 描述的是这本书存在那些英雄
    private List<Hero> heroList;

    public List<Hero> getHeroList() {
        return heroList;
    }

    public void setHeroList(List<Hero> heroList) {
        this.heroList = heroList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public Date getBpubDate() {
        return bpubDate;
    }

    public void setBpubDate(Date bpubDate) {
        this.bpubDate = bpubDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", btitle='" + btitle + '\'' +
                ", bpubDate=" + bpubDate +
                ", heroList=" + heroList +
                '}';
    }
}
