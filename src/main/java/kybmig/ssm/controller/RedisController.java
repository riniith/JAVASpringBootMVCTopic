package kybmig.ssm.controller;


import kybmig.ssm.Utility;
import kybmig.ssm.model.TodoModel;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class RedisController {
    private RedisTemplate<String, String>  templateNormal;
//    private HashMap<String, String> template;
    private RedisTemplate<Integer, TodoModel>templateTodo;


    public RedisController(RedisTemplate<String, String>  templateNormal,  RedisTemplate<Integer, TodoModel> templateTodo) {
        this.templateNormal = templateNormal;
        this.templateTodo = templateTodo;
    }
    
    @GetMapping("/redis/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("redis/index");

        String value = templateNormal.opsForValue().get("testkey");
        if (value == null) {
            value = "redis 中没有 testkey 对应的值";
        }

        mv.addObject("key", value);


        TodoModel t = new TodoModel();
        t.setContent("testRedisTodo");

        templateTodo.opsForValue().set(1, t);

        TodoModel tFromRedis = templateTodo.opsForValue().get(1);

        Utility.log("tFromRedis %s", tFromRedis);
    
        
        

        return mv;
    }

    @GetMapping("/redis/set")
    public String set(String value) {
        if (value == null) {
            value = "gua";
        }
        // 往 redis 里面存一个值
        templateNormal.opsForValue().set("testkey", value);
        
        
        templateNormal.convertAndSend("messageQueue", "请处理这个请求");
        
        return "redirect:/redis/index";
    }



}
