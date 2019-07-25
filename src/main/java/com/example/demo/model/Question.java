package com.example.demo.model;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private Integer id;
    private String title;
    private String description;
    private String tag;
    @JSONField(name = "GMT_CREATE")
    private  Long cmtCreate;
    @JSONField(name = "GMT_MODIFIED")
    private Long cmtModified;
    private Integer create;
    private Integer commentCount;
    private Integer vieCount;
    private Integer likeCount;
}
