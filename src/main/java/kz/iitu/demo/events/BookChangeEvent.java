package kz.iitu.demo.events;

import kz.iitu.demo.entity.Book;
import org.springframework.context.ApplicationEvent;

public class BookChangeEvent extends ApplicationEvent {

    private Book book;
    private String changeType;


    public BookChangeEvent(Object source, Book book, String changeType) {
        super(source);
        this.book = book;
        this.changeType = changeType;
    }

    public Book getBook() {
        return book;
    }

    public String getChangeType() {
        return changeType;
    }
}
