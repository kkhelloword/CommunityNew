package com.example.demo.mapper;


import com.example.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    @Insert("insert into user (ACCOUNT_ID,NAME,TOKEN,GMT_CREATE,GMT_MODIFIED,avatar_url) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insertUser(User user);

//    通过token查询用户信息是否存在
    @Select("select * from user where token = #{token}")
    User selectUser(@Param("token") String token);
}
