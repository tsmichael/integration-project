package os.producer.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import os.producer.model.Article;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AnimeNewsPage extends AbstractPage {

    private By articlesList = By.cssSelector(".sentinel-listing-page-list article .bc-info");

    private By articleTitle = By.cssSelector("h3 a");
    private By articleDescription = By.cssSelector("p");
    private By articleAuthor = By.cssSelector(".bc-details a");
    private By articleDate = By.cssSelector(".bc-date");

    private final String DATETIME_ATTRIBUTE = "datetime";

    public AnimeNewsPage proceedToAnimeNewsCategoryPage() {
        proceedToPage();
        return this;
    }

    public List<WebElement> getArticleBlocks() {
        return getElements(articlesList);
    }

    public List<Article> getArticle(List<WebElement> articleBlocks) {
        List<Article> articles = new ArrayList<>();
        for (WebElement articleBlock : articleBlocks) {
            String title = articleBlock.findElement(articleTitle).getText();
            String description = articleBlock.findElement(articleDescription).getText();
            String author = articleBlock.findElement(articleAuthor).getText();
            String date = articleBlock.findElement(articleDate).getAttribute(DATETIME_ATTRIBUTE);
            Instant timestamp = Instant.parse(date);

            articles.add(new Article.Builder()
                    .withTitle(title)
                    .withAuthor(author)
                    .withDescription(description)
                    .withDate(timestamp)
                    .build());
        }

        return articles;
    }
}
