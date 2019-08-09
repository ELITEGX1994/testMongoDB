package test.gx.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * @ClassName comment
 * @Description TODO
 * @Author zhangguoxian
 * @Date 2019/8/8 19:20
 * @Version 1.0
 */

@Setter
@Getter
@Document(collection = "comment_info")
public class Comment {
    @Id
    private String id;

    @Field
    private String comment_blog_id;

    @Field
    private String comment_user_id;

    @Field
    private String comment_content;

    @Field
    private List<Responses> comment_responses;

    @Field
    private Date create_time;

    public Comment(String comment_blog_id, String comment_user_id, String comment_content, List<Responses> comment_responses, Date create_time) {
        this.comment_blog_id = comment_blog_id;
        this.comment_user_id = comment_user_id;
        this.comment_content = comment_content;
        this.comment_responses = comment_responses;
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", comment_blog_id='" + comment_blog_id + '\'' +
                ", comment_user_id='" + comment_user_id + '\'' +
                ", comment_content='" + comment_content + '\'' +
                ", comment_responses=" + comment_responses +
                ", create_time=" + create_time +
                '}';
    }
}
