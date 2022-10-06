package kybmig.ssm.controller;

import kybmig.ssm.Utility;
import kybmig.ssm.model.TodoModel;
import kybmig.ssm.model.WeiboModel;
import kybmig.ssm.service.TodoService;
import kybmig.ssm.service.WeiboService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WeiboController {

    private WeiboService weiboService;

    public WeiboController(WeiboService weiboService) {
//        this.todoService = new TodoService();
        this.weiboService = weiboService;
    }


    @PostMapping("/weibo/add")
    public ModelAndView add(String content) {
        WeiboModel weibo = weiboService.add(content);

        ModelAndView mv = new ModelAndView("redirect:/weibo");
//        return "redirect:/todo";
        return mv;
    }
//
    @GetMapping("/weibo/delete")
    public String deleteMapper(int id) {
        weiboService.deleteById(id);
        return "redirect:/weibo";
    }
//
//
//    @GetMapping("/todo/edit")
//    public ModelAndView edit(int id) {
//        TodoModel todo = todoService.findById(id);
//
//        ModelAndView m = new ModelAndView("todo_edit");
//        m.addObject("todo", todo);
//        return m;
//    }
//
//    @PostMapping("/todo/update")
//    public String updateMapper(int id, String content) {
//        todoService.update(id, content);
//        return "redirect:/todo";
//    }

    @GetMapping("/weibo")
    public ModelAndView index() {

        List<WeiboModel> weibos = this.weiboService.all();
        ModelAndView m = new ModelAndView("weibo/index");
        m.addObject("weibos", weibos);
        return m;
    }
}
