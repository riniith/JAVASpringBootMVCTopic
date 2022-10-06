package kybmig.ssm.controller;

import jdk.jshell.execution.Util;
import kybmig.ssm.Utility;
import kybmig.ssm.model.TopicCommentModel;
import kybmig.ssm.model.TopicModel;
import kybmig.ssm.model.UserModel;
import kybmig.ssm.service.TopicService;
import kybmig.ssm.service.UserService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
public class TopicController {
    private HashMap<Integer, String> tokenMap = new HashMap<>();

    private TopicService topicService;
    private UserService userService;

    public TopicController(TopicService topicService, UserService userService) {
        this.topicService = topicService;
        this.userService = userService;
    }


    @PostMapping("/topic/add")
    public ModelAndView add(String title, String content, HttpServletRequest request) {
        UserModel current = userService.currentUser(request);
        TopicModel topic = topicService.add(current.getId(), title, content);
//        TopicModel Topic = TopicService.addBySQL(content);

        ModelAndView mv = new ModelAndView("redirect:/topic");
//        return "redirect:/Topic";
        return mv;
    }

    @PostMapping("/topic/addComment")
    public ModelAndView addComment(Integer topicId,String content, HttpServletRequest request) {
        UserModel current = userService.currentUser(request);
        TopicCommentModel topicComment = topicService.addComment(current.getId(), content,topicId);
//        TopicModel Topic = TopicService.addBySQL(content);

        ModelAndView mv = new ModelAndView("redirect:/topic/detail/"+topicId);
//        return "redirect:/Topic";
        return mv;
    }

    @GetMapping("/topic/delete")
    public ModelAndView deleteMapper(int id, String token, HttpServletRequest request) {
        UserModel current = userService.currentUser(request);
        String userToken = tokenMap.get(current.getId());
        if (userToken.equals(token)) {
            topicService.deleteById(id);
            ModelAndView mv = new ModelAndView("redirect:/topic");
            return mv;
        } else {
            Utility.log("token不一致 不能删除");
            ModelAndView mv = new ModelAndView("redirect:/login");
            return mv;
        }


    }
//
//
    @GetMapping("/Topic/edit")
    public ModelAndView edit(int id) {

        TopicModel topic = topicService.findByIdWithCommentsAndUser(id);

        ModelAndView m = new ModelAndView("Topic_edit");
        m.addObject("Topic", topic);
        return m;
    }

    @PostMapping("/Topic/update")
    public String updateMapper(int id, String title,String content) {
        topicService.update(id,title, content);
        return "redirect:/topic/detail/"+id;
    }

    @GetMapping("/topic/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id ,HttpServletRequest request) {
        String token = UUID.randomUUID().toString();
        UserModel current = userService.currentUser(request);
        tokenMap.put(current.getId(), token);
        TopicModel topic = topicService.findByIdWithCommentsAndUser(id);
        UserModel user = userService.findById(topic.getUserId());
        Utility.log("topic comment %s", topic.getCommentList());
        ModelAndView mv = new ModelAndView("topic/detail");
        Utility.log("topic create time %s", topic.getCreatedTime());
        mv.addObject("topic", topic);
        mv.addObject("user", user);
        mv.addObject("token", token);
        return mv;
    }


    @GetMapping("/topic")
    public ModelAndView index(HttpServletRequest request) {
        String token = UUID.randomUUID().toString();
        UserModel current = userService.currentUser(request);
        tokenMap.put(current.getId(), token);

        List<TopicModel> Topics = this.topicService.all();
        ModelAndView m = new ModelAndView("topic/index");
        m.addObject("topics", Topics);
        m.addObject("token", token);
        return m;
    }
    
}
