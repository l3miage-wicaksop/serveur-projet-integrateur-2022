package com.example.model;

import java.util.List;

public class Chami {
    private int age;
    private String login;
    private String description;
    private String userId;
    private List<Defi> defis;


    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Chami [age=" + age + ", description=" + description + ", login=" + login + "]";
    }

    
}
