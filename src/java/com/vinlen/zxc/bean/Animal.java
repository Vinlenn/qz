package com.vinlen.zxc.bean;

public class Animal {
   private String name;
   private String like;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public Animal(String name, String like) {
        this.name = name;
        this.like = like;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", like='" + like + '\'' +
                '}';
    }
}
