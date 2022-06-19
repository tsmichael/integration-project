package os.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import os.model.Article;
import os.service.ArticleService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ArticleQuery implements GraphQLQueryResolver {

    private final ArticleService articleService;

    public Article articleById(Integer id){
        return articleService.getById(id);
    }

    public List<Article> articles(){
        return articleService.getAllArticles();
    }
}
