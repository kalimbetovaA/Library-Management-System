package kz.iitu.demo.controller;


import kz.iitu.demo.entity.Author;
import kz.iitu.demo.entity.Book;
import kz.iitu.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public List<Author> findAllAuthors() {
        return authorService.findAllAuthors();
    }

    public Author findAuthorById(Long id) {
        return authorService.findAuthorById(id);
    }

    public List<Author> searchAuthors(String keyword) {
        return authorService.searchAuthors(keyword);
    }

    public void createAuthor(Author author) {
        authorService.createAuthor(author);
    }

    public void updateAuthor(Long id, Author author) {
        authorService.updateAuthor(id, author);
    }

    public void deleteAuthor(Long id) {
        authorService.deleteAuthor(id);
    }


}
