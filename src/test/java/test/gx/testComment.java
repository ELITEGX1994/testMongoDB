package test.gx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.gx.Service.CommentDao;
import test.gx.model.Comment;
import test.gx.model.Responses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName testComment
 * @Description TODO
 * @Author zhangguoxian
 * @Date 2019/8/8 19:32
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class testComment extends GxApplicationTests{

    @Autowired
    private CommentDao commentDao;

    @Test
    public void testAdd(){
        List<Responses> comment_responses = new ArrayList<Responses>();
        Responses responses1 = new Responses();
        Responses responses2 = new Responses();
        responses1.setCreate_time(new Date());
        responses1.setGet_reply( "这是A给B的某一个评论的回复如果有就对应插入index对应的元素没有就是空串","这是B给A的评论(带着索引index)", "这是B给A的评论(带着索引index)");
        Comment comment = new Comment();
        comment.setComment_blog_id("blog id");
        comment.setComment_content("A的评论");
        comment.setComment_responses();
        comment.setComment_user_id("A");
        comment.setCreate_time(new Date());
    }
}
