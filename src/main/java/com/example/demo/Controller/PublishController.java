package com.example.demo.Controller;

import com.example.demo.mapper.QuestionMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Question;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    User user;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String getPublish(){
        return "publish";
    }


   @PostMapping("/publish")
    public String question(
            Question question,
            Model model,
            HttpServletRequest request
   ){
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());
        if (StringUtils.isEmpty(question.getTitle())){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
       if (StringUtils.isEmpty(question.getDescription())){
           model.addAttribute("error","描述不能为空");
           return "publish";
       }
       if (StringUtils.isEmpty(question.getTag())){
           model.addAttribute("error","标签不能为空");
           return "publish";
       }

       Cookie[] cookies = request.getCookies();
       if (cookies!=null && cookies.length!=0){
           for (Cookie cookie : cookies) {
               if (cookie.getName().equals("token")){
                  user = userMapper.selectUser(cookie.getValue());
                   request.getSession().setAttribute("user",user);
               }
           }
       }
       if (user == null){
           model.addAttribute("error","请登录");
           return "publish";
       }
       question.setCmtCreate(System.currentTimeMillis());
       question.setCmtModified(question.getCmtCreate());

       question.setCreate(user.getId());
       questionMapper.insertQuestion(question);
       return "index";
   }
}
