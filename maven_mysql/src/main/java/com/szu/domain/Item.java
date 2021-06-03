package com.szu.domain;

public class Item {
    private Integer id;
    private String ename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                '}';
    }
}
