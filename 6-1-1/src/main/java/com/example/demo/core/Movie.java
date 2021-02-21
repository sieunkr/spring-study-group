package com.example.demo.core;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {

    private String title;
    private String link;
    private String image;
    private String subtitle;
    private String actor;
    private String director;
    //private Date pubDate;
    private float userRating;

}