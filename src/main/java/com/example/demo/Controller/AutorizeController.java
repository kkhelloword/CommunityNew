package com.example.demo.Controller;


import com.example.demo.dto.GithubAccess;
import com.example.demo.dto.GithubGetUserInfo;
import com.example.demo.provide.GithubProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AutorizeController {

    @Autowired
    private GithubProvide githubProvide;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        GithubAccess githubAccess = new GithubAccess();
        githubAccess.setClient_id("5e52ee63aefdaf93afea");
        githubAccess.setClient_secret("6791c8bb6d0b1e42f99886c36429be7dd35f07b5");
        githubAccess.setCode(code);
        githubAccess.setRedirect_uri("http://localhost:8887/callback");
        githubAccess.setState(state);
        String token = githubProvide.getToken(githubAccess);
        GithubGetUserInfo userInfo = githubProvide.getuserInfo(token);
        System.out.println(userInfo.getBio());
        System.out.println(userInfo.getId());
        System.out.println(userInfo.getName());
        System.out.println(111);
        return "index";
    }
}
