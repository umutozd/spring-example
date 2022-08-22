package com.umutozd.springexample.types;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class User {
    private String id;
    private String name;
    private Integer age;

    public User() {
        this.id = "";
        this.name = "";
        this.age = 0;
    }

    public User(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @JsonGetter
    public String getId() {
        return id;
    }

    @JsonGetter
    public String getName() {
        return name;
    }

    @JsonGetter
    public Integer getAge() {
        return age;
    }

    @JsonSetter
    public void setId(String id) {
        this.id = id;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }

    @JsonSetter
    public void setAge(Integer age) {
        this.age = age;
    }
}
