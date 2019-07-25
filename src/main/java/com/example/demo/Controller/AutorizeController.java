package com.example.demo.Controller;


import com.example.demo.dto.GithubAccess;
import com.example.demo.dto.GithubGetUserInfo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.provide.GithubProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AutorizeController {

    @Autowired
    private GithubProvide githubProvide;

    @Autowired
    private UserMapper userMapper;

    @Value("${git.Client_id}")
    private String clientId;

    @Value("${git.Client_secret}")
    private String ClientSecret;

    @Value("${git.Uri}")
    private String Uri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                            HttpServletResponse response){
        GithubAccess githubAccess = new GithubAccess();
        githubAccess.setClient_id(clientId);
        githubAccess.setClient_secret(ClientSecret);
        githubAccess.setCode(code);
        githubAccess.setRedirect_uri(Uri);
        githubAccess.setState(state);
        String token = githubProvide.getToken(githubAccess);
        GithubGetUserInfo userInfo = githubProvide.getuserInfo(token);
        if (userInfo!=null && !userInfo.getId().equals("")){
            User user = new User();
            user.setName(userInfo.getName());
            user.setToken(UUID.randomUUID().toString());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAccountId(String.valueOf(userInfo.getId()));
            user.setAvatarUrl(userInfo.getAvatarUrl());
            System.out.println(user);
            userMapper.insertUser(user);
            response.addCookie(new Cookie("token",user.getToken()));
            return "redirect:/";
        }
        return "redirect:/";
    }
}
