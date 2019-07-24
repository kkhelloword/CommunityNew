package com.example.demo.Controller;

import com.example.demo.mapper.QuestionMapper;
import com.example.demo.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String getPublish(){
        return "publish";
    }


   @PostMapping("/publish")
    public String question(
            Question question,
            Model model
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
       System.out.println(question);
       return "index";
   }
}
