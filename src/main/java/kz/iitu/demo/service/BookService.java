package kz.iitu.demo.service;

import kz.iitu.demo.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService{
    public List<Book> findAllBooks();

    public List<Book> searchBooks(String keyword);

    public Book findBookById(Long id);

    public void createBook(Book book);

    public void updateBook(Long id, Book book);

    public void deleteBook(Long id);
}
