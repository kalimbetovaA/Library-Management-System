package kz.iitu.demo.service;

import kz.iitu.demo.entity.Author;
import kz.iitu.demo.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    public List<Author> findAllAuthors();

    public List<Author> searchAuthors(String keyword);

    public Author findAuthorById(Long id);

    public void createAuthor(Author author);

    public void updateAuthor(Long id, Author author);

    public void deleteAuthor(Long id);

}
