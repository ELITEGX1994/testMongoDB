package test.gx.Service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import test.gx.model.Article;

@Repository
public interface ArticleDao extends MongoRepository<Article,String> {

}
