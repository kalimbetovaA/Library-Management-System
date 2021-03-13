package kz.iitu.demo.controller;


import kz.iitu.demo.entity.Book;
import kz.iitu.demo.entity.Publisher;
import kz.iitu.demo.service.BookService;
import kz.iitu.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public List<Book> getAll() {
        return bookService.findAllBooks();
    }

    public Book findBookById(Long id) {
        return bookService.findBookById(id);
    }

    public List<Book> searchBooks(String keyword) {
        return bookService.searchBooks(keyword);
    }

    public void createBook(Book book) {
        bookService.createBook(book);
    }

    public void updateBook(Long id, Book book) {
        bookService.updateBook(id, book);
    }

    public void deleteBook(Long id) {
        bookService.deleteBook(id);
    }


}
