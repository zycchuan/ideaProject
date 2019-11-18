package com.zyc.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private Integer id;
    @JsonProperty("username")
    private String name;
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bri;

    public User() {
    }

    public User(Integer id, String name, Integer age, Date bri) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bri = bri;
    }

    public Date getBri() {
        return bri;
    }

    public void setBri(Date bri) {
        this.bri = bri;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
