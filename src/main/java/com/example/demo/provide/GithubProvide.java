package com.example.demo.provide;

import com.alibaba.fastjson.JSON;
import com.example.demo.dto.GithubAccess;
import com.example.demo.dto.GithubGetUserInfo;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class GithubProvide {

    public String getToken(GithubAccess access) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(access));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return  response.body().string().split("&")[0].split("=")[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubGetUserInfo getuserInfo(String token) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + token)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubGetUserInfo userInfo = JSON.parseObject(string, GithubGetUserInfo.class);
            return userInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
