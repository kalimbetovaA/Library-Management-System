package kz.iitu.demo.service.impl;

import kz.iitu.demo.entity.Author;
import kz.iitu.demo.entity.Book;
import kz.iitu.demo.entity.Publisher;
import kz.iitu.demo.events.BookChangeEvent;
import kz.iitu.demo.repository.BookRepository;
import kz.iitu.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService, ApplicationEventPublisherAware {

    @Autowired
    private BookRepository bookRepository;

    private ApplicationEventPublisher eventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String keyword) {
        if (keyword != null) {
            return bookRepository.search(keyword);
        }
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
        this.eventPublisher.publishEvent(new BookChangeEvent(this, book, "added"));
    }

    @Override
    public void updateBook(Long id, Book book) {
        Optional<Book> bookOptional = bookRepository.findById(book.getId());

        if (bookOptional.isPresent()) {
            Book dbBook = bookOptional.get();
            dbBook.setName(book.getName());
            dbBook.setDescription(book.getDescription());
            dbBook.setGenre(book.getGenre());
            dbBook.setAuthors(book.getAuthors());
            dbBook.setPublisher(book.getPublisher());
            bookRepository.save(dbBook);

            this.eventPublisher.publishEvent(new BookChangeEvent(this, book, "updated"));
        }
    }

    @Override
    public void deleteBook(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            this.eventPublisher.publishEvent(new BookChangeEvent(this, bookOptional.get(), "deleted"));
            bookRepository.deleteById(id);
        }
    }

}
