package com.fred.persist.entity;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Created by Fred on 05/03/2017.
 */
public class Greeting {

    private long id;
    private String content;

    public Greeting(){
    }

    public Greeting(int id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    @JsonView(Views.Resume.class)
    public void setId(long id) {
        this.id = id;
    }

    @JsonView(Views.Resume.class)
    public void setContent(String content) {
        this.content = content;
    }
}
