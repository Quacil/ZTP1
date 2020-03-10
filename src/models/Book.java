package models;

import java.util.Date;
import java.util.UUID;

public class Book {
    private final String title;
    private final String author;
    private final Date publishedOn;
    private final UUID id;

    public Book(String title, String author, Date publishedOn, UUID id) {
        this.title = title;
        this.author = author;
        this.publishedOn = publishedOn;
        this.id = id;
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

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return title + " by " + author + ", published on " + publishedOn;
    }
}
