package test.gx.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * @ClassName Article
 * @Description TODO
 * @Author zhangguoxian
 * @Date 2019/8/8 15:33
 * @Version 1.0
 */
@Setter
@Getter
@Document(collection = "article_info")
public class Article {
    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("url")
    private String url;

    @Field("author")
    private String author;

    @Field("tags")
    private List<String> tags;

    @Field("visit_count")
    private Long visitCount;

    @Field("add_time")
    private Date addTime;

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", author='" + author + '\'' +
                ", tags=" + tags +
                ", visitCount=" + visitCount +
                ", addTime=" + addTime +
                '}';
    }
}
