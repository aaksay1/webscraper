package com.example.webscrape.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "scrape")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Scrape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scrape_id")
    private Long id;

    @Column(name = "link")
    private String link;

    @Column(name = "title")
    private String title;

    @Column(name = "time") 
    private Long time;

    public Scrape() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
    
}
