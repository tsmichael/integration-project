package os.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import os.model.Article;
import os.model.ArticleRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article getById(Integer id){
        Optional<Article> article = articleRepository.findById(id);
        return article.orElse(null);
    }

    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }


}
