package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Indication  {
    @Id
    @GeneratedValue
    private int idIndice;

   
    @Column(name="indice",length = 1000)
    private String text;

    @Column(name="srcVideo",length = 1000)
    private String srcVideo;

    @Column(name="srcImage",length = 1000)
    private String srcImage;

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSrcVideo() {
        return this.srcVideo;
    }

    public void setSrcVideo(String srcVideo) {
        this.srcVideo = srcVideo;
    }

    public String getSrcImage() {
        return this.srcImage;
    }

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }



    

}
