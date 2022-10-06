package kybmig.ssm.service;


import kybmig.ssm.mapper.UserMapper;
import kybmig.ssm.model.UserModel;
import kybmig.ssm.model.UserRole;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {
    private UserMapper mapper;
    
     public UserService(UserMapper UserMapper) {
         this.mapper = UserMapper;
     }
    
    public UserModel add(String username, String password) {
        UserModel m = new UserModel();
        m.setUsername(username);
        m.setPassword(password);
        m.setRole(UserRole.normal);
        this.mapper.insert(m);
        return m;
    }
    
    public  void update(Integer id, String username, String password) {
        UserModel m = new UserModel();
        m.setId(id);
        m.setUsername(username);
        m.setPassword(password);
        this.mapper.update(m);
    }

    public void deleteById(Integer id) {
        this.mapper.delete(id);
    }


    public UserModel findById(Integer id) {
        UserModel r = this.mapper.selectOne(id);
        return r;
    }


    public UserModel findByUsername(String ussername) {
        UserModel r = this.mapper.selectOneByUsername(ussername);
        return r;
    }
    public  List<UserModel> all() {
        return this.mapper.selectAll();
    }
    
    public boolean validateLogin(String username, String  password) {
         UserModel user = mapper.selectOneByUsername(username);
         if (user != null && user.getPassword().equals(password)) {
             return true;
         } else {
             return false;
         }
    }

    public UserModel guest() {
        UserModel user = new UserModel();
        user.setRole(UserRole.guest);
        user.setId(-1);
        user.setUsername("游客");
        user.setPassword("游客");
        return user;
    }
    
    public UserModel currentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("user_id");
        if (id == null) {
            return this.guest();
        }
        UserModel user = mapper.selectOne(id);
        if (user == null) {
            user = this.guest();
        }
        return user;
    }
}
