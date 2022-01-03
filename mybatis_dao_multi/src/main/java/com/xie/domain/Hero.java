package com.xie.domain;

public class Hero {
    private int id;
    private String hname;
    private int hgender;
    private String hcomment;
    private Book book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public int getHgender() {
        return hgender;
    }

    public void setHgender(int hgender) {
        this.hgender = hgender;
    }

    public String getHcomment() {
        return hcomment;
    }

    public void setHcomment(String hcomment) {
        this.hcomment = hcomment;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", hname='" + hname + '\'' +
                ", hgender=" + hgender +
                ", hcomment='" + hcomment + '\'' +
                ", book=" + book +
                '}';
    }
}
