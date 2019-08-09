package test.gx.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import test.gx.model.Article;

import java.util.List;

/**
 * @ClassName ArticleServiceImpl
 * @Description TODO
 * @Author zhangguoxian
 * @Date 2019/8/8 16:32
 * @Version 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveArticle(Article article) {
        //使用 save和insert都可以进行插入
        //区别：当存在"_id"时
        //insert 插入已经存在的id时 会异常
        //save 则会进行更新
        //简单来说 save 就是不存在插入 存在更新
        //mongoTemplate.insert(article);
        mongoTemplate.save(article);
    }

    @Override
    public Article findById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.find(query,Article.class).get(0);
    }

    @Override
    public List<Article> findByTitle(String title) {
        Query query = new Query(Criteria.where("id").is(title));
        return mongoTemplate.find(query,Article.class);
    }

    @Override
    public Article delete(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findAndRemove(query,Article.class);
    }

    @Override
    public Article deleteTitle(String title) {
        Query query = new Query(Criteria.where("title").is(title));
        return mongoTemplate.findAndRemove(query,Article.class);
    }

    @Override
    public List<Article> deleteAllTitle(String title) {
        Query query = new Query(Criteria.where("title").is(title));
        return mongoTemplate.findAllAndRemove(query,Article.class);
    }
}
