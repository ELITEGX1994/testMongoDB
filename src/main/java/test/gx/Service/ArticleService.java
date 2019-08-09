package test.gx.Service;

import org.springframework.stereotype.Repository;
import test.gx.model.Article;

import java.util.List;

public interface ArticleService {
    void saveArticle(Article article);
    Article findById(String id);
    List<Article> findByTitle(String title);
    Article delete(String id);
    Article deleteTitle(String title);
    List<Article> deleteAllTitle(String title);
}
