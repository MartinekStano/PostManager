package com.example.amcef.bussiness.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Formatter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post implements Serializable {

    private int userId;
    private int id;
    private String title;
    private String body;

    public Post(int id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

}
