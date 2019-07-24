package com.example.demo.mapper;

import com.example.demo.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface QuestionMapper {

    @Insert("insert into question (title,description,cmt_create,cmt_modified,tag) values (#{title},#{description},#{cmtCreate},#{cmtModified},#{tag})")
     void insertQuestion(Question question);
}
