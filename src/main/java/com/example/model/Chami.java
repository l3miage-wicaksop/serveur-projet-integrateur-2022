package com.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name="chamis")
public class Chami {

    // userId est le login
    @Id
    @Column(name="user_id")
    private String userId;

    @Column(name = "age")
    private int age;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "auteur")
    private List<Defi> defis;
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Chami [age=" + age + ", description=" + description + ", login=" + userId + "]";
    }

    
}
