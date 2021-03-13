package kz.iitu.demo.events;

import kz.iitu.demo.entity.Author;
import org.springframework.context.ApplicationEvent;

public class AuthorChangeEvent extends ApplicationEvent {

    private Author author;
    private String changeType;


    public AuthorChangeEvent(Object source, Author author, String changeType) {
        super(source);
        this.author = author;
        this.changeType = changeType;
    }

    public Author getAuthor() {
        return author;
    }

    public String getChangeType() {
        return changeType;
    }
}
