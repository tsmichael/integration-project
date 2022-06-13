package os.consumer.jdbc;

import os.model.Article;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryDB {

    static Statement insertStatement = null;

    private QueryDB() {
    }

    public static void insertIntoArticleTable(Article article) {

        Connection connectionDb = JdbcUtils.getConnectionDb();
        try {
            insertStatement = connectionDb.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String keysJoined = getArticleKeys();

        String sql = "INSERT INTO articles (" + keysJoined + ") values (" + article.toDbString() + ");";
        System.out.println(sql);
        try {
            insertStatement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getArticleKeys() {
        List<String> keys = new ArrayList<>();

        for (Field field : Article.class.getDeclaredFields()) {
            keys.add(field.getName());
        }

        keys.remove("serialVersionUID");
        keys.remove("id");

        return String.join(",", keys);
    }


}
