package test.gx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;
import test.gx.Service.ArticleDao;
import test.gx.Service.ArticleService;
import test.gx.Service.ArticleServiceImpl;
import test.gx.model.Article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName testArticle
 * @Description TODO
 * @Author zhangguoxian
 * @Date 2019/8/8 15:42
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class testArticle extends GxApplicationTests{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void initArticle(){
        //循环添加
        for (int i = 0; i < 10; i++) {
            Article article = new Article();
            article.setTitle("MongoTemplate的基本使用");
            article.setAuthor("yinjihuan");
            article.setUrl("http://cxytiandi.com/blog/detail/" + i);
            article.setTags(Arrays.asList("java", "mongodb", "spring"));
            article.setVisitCount(0L);
            article.setAddTime(new Date());
            mongoTemplate.save(article);
        }

        //批量添加
        List<Article> articles = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Article article = new Article();
            article.setTitle("MongoTemplate的基本使用");
            article.setAuthor("yinjihuan");
            article.setUrl("http://cxytiandi.com/blog/detail/" + i);
            article.setTags(Arrays.asList("java", "mongodb", "spring"));
            article.setVisitCount(0L);
            article.setAddTime(new Date());
            articles.add(article);
        }
        mongoTemplate.insert(articles, Article.class);
    }

    @Test
    public void testDelete(){
       List <Article> article = articleService.deleteAllTitle("MongoTemplate的基本使用");
//        Query query = new Query(Criteria.where("title").is("MongoTemplate的基本使用"));
//        List<Article> articles = mongoTemplate.findAllAndRemove(query,Article.class);
        System.out.println(article.toString());
    }

    @Test
    public void testAddByRepository(){
        Article article = new Article();
        article.setTitle("MongoTemplate的基本使用");
        article.setAuthor("yinjihuan");
        article.setUrl("http://cxytiandi.com/blog/detail/" + 1);
        article.setTags(Arrays.asList("java", "mongodb", "spring"));
        article.setVisitCount(0L);
        article.setAddTime(new Date());
        articleDao.save(article);
    }

}
