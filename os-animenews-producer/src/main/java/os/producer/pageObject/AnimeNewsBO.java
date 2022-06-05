package os.producer.pageObject;

import org.openqa.selenium.WebElement;
import os.producer.model.Article;

import java.util.List;

public class AnimeNewsBO {

    private AnimeNewsPage animeNewsPage;

    public AnimeNewsBO() {
        animeNewsPage = new AnimeNewsPage();
    }

    public AnimeNewsBO proceedToAnimeNewsCategoryPage() {
        animeNewsPage.proceedToAnimeNewsCategoryPage();
        return this;
    }

    public List<Article> getArticleBlocks() {
        List<WebElement> articles = animeNewsPage.getArticleBlocks();

        return animeNewsPage.getArticle(articles);
    }

}
