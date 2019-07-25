package com.example.demo.dto;

import lombok.Data;

@Data
public class GithubGetUserInfo {

    private String name;
    private String bio;
    private Integer id;
    private String avatarUrl;

}
