package test.gx.Service;

import org.springframework.data.mongodb.repository.MongoRepository;
import test.gx.model.Comment;

/**
 * @ClassName CommentDao
 * @Description TODO
 * @Author zhangguoxian
 * @Date 2019/8/8 19:55
 * @Version 1.0
 */
public interface CommentDao extends MongoRepository<Comment,String> {

}
