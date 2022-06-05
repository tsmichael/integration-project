package os.producer.com.application;


import os.producer.model.Article;
import os.producer.pageObject.AnimeNewsBO;
import os.producer.rabbitmq.Sender;
import os.producer.utils.CustomDriver;

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
