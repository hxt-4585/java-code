package com.powernode.spring6.bean;

public class Wife {
    private String name;
    private Husband husband;

    public Wife() {
        System.out.println("wife 被创建：");
    }

    public Wife(String name, Husband husband) {
        this.name = name;
        this.husband = husband;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }
}
