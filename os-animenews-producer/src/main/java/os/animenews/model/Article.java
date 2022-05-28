package os.animenews.model;

import java.io.Serializable;
import java.time.Instant;

public class Article implements Serializable {

    private Long id;
    private String title;
    private String description;
    private String author;
    private Instant date;

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

    public Instant getDate() {
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

        public Builder withDate(Instant date) {
            article.date = date;
            return this;
        }

        public Article build() {
            return article;
        }
    }
}
