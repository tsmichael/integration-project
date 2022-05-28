package os.animenews.com.application;


import os.animenews.model.Article;
import os.animenews.pageObject.AnimeNewsBO;
import os.animenews.rabbitmq.Sender;
import os.animenews.utils.CustomDriver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static String ROOT_URL = "https://www.cbr.com/category/anime-news/";

    public static void main(String[] args) {
        List<Article> articleList = new ArrayList<>();

        try {
            CustomDriver.initDriver();

            articleList = new AnimeNewsBO()
                    .proceedToAnimeNewsCategoryPage()
                    .getArticleBlocks();
        } finally {
            CustomDriver.quitDriver();
        }

        Sender.sendToQ(articleList);
    }

}
