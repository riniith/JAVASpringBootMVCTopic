package kybmig.ssm.service;


import kybmig.ssm.Utility;
import kybmig.ssm.mapper.TopicMapper;
import kybmig.ssm.model.TopicCommentModel;
import kybmig.ssm.model.TopicModel;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TopicService {
    private TopicMapper mapper;
    
     public TopicService(TopicMapper topicMapper) {
         this.mapper = topicMapper;
     }
    
    public TopicModel add(Integer userId, String title, String content) {

        long Time=System.currentTimeMillis() / 1000L;
        String time=Utility.formattedTime(Time);
        TopicModel m = new TopicModel();
        m.setContent(content);
        m.setTitle(title);
        m.setUserId(userId);
        m.setCreatedTime(time);
        m.setUpdatedTime(time);
        this.mapper.insertOne(m);
        return m;
    }

    public TopicCommentModel addComment(Integer userId, String content, Integer topicId) {
        long Time=System.currentTimeMillis() / 1000L;
        String time=Utility.formattedTime(Time);
        TopicCommentModel m = new TopicCommentModel();
        m.setContent(content);
        m.setUserId(userId);
        m.setTopicId(topicId);
        m.setCreatedTime(time);
        this.mapper.insertCommentOne(m);
        return m;
    }
    
    public  void update(Integer id, String title, String content) {
        long Time=System.currentTimeMillis() / 1000L;
        String time=Utility.formattedTime(Time);
        TopicModel m = new TopicModel();
        m.setId(id);
        m.setContent(content);
        m.setTitle(title);
        m.setUpdatedTime(time);
        this.mapper.update(m);
    }

    public void deleteById(Integer id) {
        this.mapper.delete(id);
    }


    public TopicModel findById(Integer id) {
        TopicModel r = this.mapper.selectOne(id);
        return r;
    }

    public TopicModel findByIdWithComments(Integer id) {
        TopicModel r = this.mapper.selectOneWithComments(id);
        return r;
    }
    public TopicModel findByIdWithCommentsAndUser(Integer id) {
        TopicModel r = this.mapper.selectOneWithCommentsAndUser(id);
        Utility.log("topic create time %s", r);
        return r;
    }



    public  List<TopicModel> all() {
        return this.mapper.selectAll();
    }
    public  List<TopicModel> userCreate(Integer userId) {
        return this.mapper.selectUserCreate(userId);
    }
}
