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

    public byte[] toBytes() {
        byte[]bytes;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.flush();
            oos.reset();
            bytes = baos.toByteArray();
            oos.close();
            baos.close();
        } catch(IOException e){
            bytes = new byte[] {};
            //Logger.getLogger("bsdlog").error("Unable to write to output stream",e);
        }
        return bytes;
    }

    public static class Builder {
        private Article article;

        public Builder() {
            article = new Article();
        }

        public Builder withId(Long id) {
            article.id = id;
            return this;
        }

        public Builder withTitle(String title) {
            article.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            article.description = description;
            return this;
        }

        public Builder withAuthor(String author) {
            article.author = author;
            return this;
        }

        public Builder withDate(Timestamp date) {
            article.date = date;
            return this;
        }

        public Article build() {
            return article;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) && Objects.equals(title, article.title) && Objects.equals(description, article.description) && Objects.equals(author, article.author) && Objects.equals(date, article.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, author, date);
    }
}
