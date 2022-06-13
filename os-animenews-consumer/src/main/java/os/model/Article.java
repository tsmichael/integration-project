package os.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Article implements Serializable {

    private static final long serialVersionUID = -1056010380112071781L;
    private Long id;
    private String title;
    private String description;
    private String author;
    private Timestamp date;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public Timestamp getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }

    public String toDbString() {
        this.title = getTitle().replace("'","");
        this.description = getDescription().replace("'","");
        this.author = getAuthor().replace("'","");
        return "\'" + title + "\',\'" + description + "\',\'" + author + "\',\'" + date + "\'";
    }
}
