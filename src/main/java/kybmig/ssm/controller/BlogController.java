package kybmig.ssm.controller;

import kybmig.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BlogController {

    UserService userService;

    public BlogController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/blog")
    public ModelAndView blog(HttpServletRequest request) {
        // model 说的是给模板引擎的 model
        // view 说的是模板名字，没有后缀
        // view 可以自动补全，也可以直接跳转
        ModelAndView mv = new ModelAndView("blog/index");

        return mv;
    }

    @GetMapping("/blog/StartBlog")
    public ModelAndView StartBlog(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("blog/StartBlog");
        return mv;
    }

    @GetMapping("/blog/FrenchB1")
    public ModelAndView FrenchB1(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("blog/FrenchB1");
        return mv;
    }
}
