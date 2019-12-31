package com.example.entity;

public class Keh {
    private int id;
    private String name;
    private String costom;
    private String mobile;
    private String DB;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCostom() {
        return costom;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDB() {
        return DB;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCostom(String costom) {
        this.costom = costom;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setDB(String DB) {
        this.DB = DB;
    }

    @Override
    public String toString() {
        return "Keh{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", costom='" + costom + '\'' +
                ", mobile='" + mobile + '\'' +
                ", DB='" + DB + '\'' +
                '}';
    }
}

