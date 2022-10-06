package kybmig.ssm.controller;


import kybmig.ssm.Utility;
import kybmig.ssm.model.TopicModel;
import kybmig.ssm.model.UserModel;
import kybmig.ssm.service.TopicService;
import kybmig.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    UserService userService;
    TopicService topicService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/register")
    public ModelAndView registerView() {
        ModelAndView mv = new ModelAndView("user/register");
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView loginView() {
        ModelAndView mv = new ModelAndView("user/login");
        return mv;
    }

    @PostMapping("/user/add")
    public ModelAndView register(String username, String password) {
        userService.add(username, password);
        ModelAndView mv = new ModelAndView("redirect:/login");
        return mv;
    }

    @PostMapping("/user/login")
    public ModelAndView login(String username, String password, HttpServletRequest request) {
       if(userService.validateLogin(username, password)) {
           UserModel current = userService.findByUsername(username);
           request.getSession().setAttribute("user_id", current.getId());

           ModelAndView mv = new ModelAndView("redirect:/");
           return mv;
       } else {
           ModelAndView mv = new ModelAndView("redirect:/login");
           return mv;
       }
    }

    @GetMapping("/user/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id , HttpServletRequest request) {
        UserModel user = userService.findById(id);
        int userId =id;
        List<TopicModel> Topics = this.topicService.userCreate(userId);
        ModelAndView mv = new ModelAndView("user/detail");
        mv.addObject("user", user);
        mv.addObject("Topics", Topics);
        return mv;
    }

}
