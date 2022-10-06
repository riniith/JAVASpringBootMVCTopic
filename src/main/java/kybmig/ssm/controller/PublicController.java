package kybmig.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import kybmig.ssm.Utility;
import kybmig.ssm.model.TopicModel;
import kybmig.ssm.model.UserModel;
import kybmig.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PublicController {

    UserService userService;

    public PublicController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public ModelAndView index(HttpServletRequest request) {
        UserModel  current = userService.currentUser(request);

        // model 说的是给模板引擎的 model
        // view 说的是模板名字，没有后缀
        // view 可以自动补全，也可以直接跳转
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("username", current.getUsername());

        return mv;
    }

    @PostMapping("/ajax/test")
    @ResponseBody
    public String ajaxTest(@RequestBody String body) {
        Utility.log("body <%s>", body);
        JSONObject json = JSON.parseObject(body);
        String content = json.getString("content");
        Utility.log("content: %s", content);
        UserModel user = userService.findById(1);
        String j = JSON.toJSONString(user);
        return j;
    }

}
