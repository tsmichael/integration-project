package os.animenews.com.application;


import os.animenews.pageObject.AnimeNewsBO;
import os.animenews.utils.CustomDriver;

public class Main {
    private final static String ROOT_URL = "https://www.cbr.com/category/anime-news/";

    public static void main(String[] args) {
       try {
           CustomDriver.initDriver();

           new AnimeNewsBO()
                   .proceedToAnimeNewsCategoryPage()
                   .getArticleBlocks();
       }
       finally {
           CustomDriver.quitDriver();
       }
    }

}
