package kybmig.ssm.controller;
import kybmig.ssm.Utility;
import kybmig.ssm.mapper.TodoMapper;
import kybmig.ssm.model.TodoModel;
import kybmig.ssm.model.TopicModel;
import kybmig.ssm.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
//        this.todoService = new TodoService();
        this.todoService = todoService;
    }


    @PostMapping("/todo/add")
    public ModelAndView add(String content) {
//        content = content.replace(">", "&gt");
//        content = content.replace("<", "&lt");

        TodoModel todo = todoService.add(content);
//        TodoModel todo = todoService.addBySQL(content);

        ModelAndView mv = new ModelAndView("redirect:/todo");
//        return "redirect:/todo";
        return mv;
    }

    @GetMapping("/todo/delete")
    public String deleteMapper(int id) {
        todoService.deleteById(id);
        return "redirect:/todo";
    }


    @GetMapping("/todo/edit")
    public ModelAndView edit(int id) {
        TodoModel todo = todoService.findById(id);

        ModelAndView m = new ModelAndView("todo_edit");
        m.addObject("todo", todo);
        return m;
    }

    @PostMapping("/todo/update")
    public String updateMapper(int id, String content) {
        todoService.update(id, content);
        return "redirect:/todo";
    }

    @GetMapping("/todo")
    public ModelAndView index() {
        Utility.log("/todo 路由开始");
//        List<TodoModel> todos = this.todoService.all();
        List<TodoModel> todos = this.todoService.all();
        ModelAndView m = new ModelAndView("todo_index");
        m.addObject("todos", todos);
        Utility.log("/todo 路由结束");
        return m;
    }

    @GetMapping("/trans")
    @Transactional
    public ModelAndView trans() {
        TodoModel t = todoService.add("trans");
        TodoModel t2 = todoService.add("trans2");
        if (true) {
            throw new RuntimeException("eee");
        }
        ModelAndView mv = new ModelAndView("redirect:/todo");
        return mv;
    }
}
