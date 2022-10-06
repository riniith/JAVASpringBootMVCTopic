package kybmig.ssm.service;


import com.mysql.cj.jdbc.MysqlDataSource;
import kybmig.ssm.Utility;
import kybmig.ssm.mapper.TodoMapper;
import kybmig.ssm.model.ModelFactory;
import kybmig.ssm.model.TodoModel;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private TodoMapper mapper;
    
     public TodoService(TodoMapper todoMapper) {
         this.mapper = todoMapper;
     }
    
    public TodoModel add(String content) {
        TodoModel m = new TodoModel();
        m.setContent(content);
        Utility.log("m before insert id: %s", m.getId());
        this.mapper.insertTodo(m);
        Utility.log("m after insert id: %s", m.getId());

        return m;
    }
    
    public  void update(Integer id, String content) {
        TodoModel m = new TodoModel();
        m.setId(id);
        m.setContent(content);
        this.mapper.updateTodo(m);
    }

    public void deleteById(Integer id) {
        this.mapper.deleteTodo(id);
    }


    public  TodoModel findById(Integer id) {
        TodoModel r = this.mapper.selectTodo(id);
        return r;
    }

    public  List<TodoModel> all() {
        return this.mapper.selectAllTodo();
    }
}
