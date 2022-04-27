package com.example.model;

public class Chami {
    public int age;
    public String login;
    public String description;
    public String userId;


    
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
