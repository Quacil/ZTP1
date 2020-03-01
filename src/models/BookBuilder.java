package models;

import java.time.Instant;
import java.util.*;

public class BookBuilder {
    List<String> titles;
    List<String> authors;

    public BookBuilder() {
        titles = new ArrayList<String>(Arrays.asList("Perfect book", "Mediocre book", "Awful book", "Awesome book", "My favourite book"));
        authors = new ArrayList<>(Arrays.asList("Al K. Holic", "Ivana Humpalot", "Hugh Jass", "Ho Lee Phuck", "Harry P. Ness"));
    }

    public Book Random() {
        Random random = new Random();
        String title = titles.get(random.nextInt(titles.size()));
        String author = authors.get(random.nextInt(authors.size()));
        return new Book(title, author, Date.from(Instant.now()));
    }
}
