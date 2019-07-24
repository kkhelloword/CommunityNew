package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private String title;
    private String description;
    private String tag;
    private  Long cmtCreate;
    private Long cmtModified;
    private Integer create;
    private Integer commentCount;
    private Integer vieCount;
    private Integer likeCount;
}
