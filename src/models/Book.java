package models;

import java.util.Date;

public class Book {
    private final String title;
    private final String author;
    private final Date publishedOn;

    public Book(String title, String author, Date publishedOn) {
        this.title = title;
        this.author = author;
        this.publishedOn = publishedOn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    @Override
    public String toString() {
        return title + " by " + author + ", published on " + publishedOn;
    }
}
