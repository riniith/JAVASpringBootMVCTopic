package kybmig.ssm.mapper;

import kybmig.ssm.model.TopicCommentModel;
import kybmig.ssm.model.TopicModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// 这个是 spring 用来在 controller 进行依赖注入的。
@Repository
// 这个是 mybaits spring boot 用来自动跟 xml 联系起来，并注入到 spring 的 session 里面。
@Mapper
public interface TopicMapper {
    void insertOne(TopicModel m);

    void insertCommentOne(TopicCommentModel m);

    List<TopicModel> selectAll();

    List<TopicModel> selectUserCreate(int userId);



    TopicModel selectOne(int id);

    void update(TopicModel m);

    void delete(int id);

    TopicModel selectOneWithComments(int id);

    TopicModel selectOneWithCommentsAndUser(int id);


}
