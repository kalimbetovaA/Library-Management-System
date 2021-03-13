package kz.iitu.demo.service.impl;

import javassist.NotFoundException;
import kz.iitu.demo.entity.Author;
import kz.iitu.demo.repository.AuthorRepository;
import kz.iitu.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService, ApplicationEventPublisherAware {

    @Autowired
    private AuthorRepository authorRepository;

    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> searchAuthors(String keyword) {
        if (keyword != null) {
            return authorRepository.search(keyword);
        }
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorRepository.findById(id).get();

    }

    @Override
    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void updateAuthor(Long id, Author author) {
        Optional<Author> authorOptional = authorRepository.findById(id);

        if (authorOptional.isPresent()) {
            Author dbAuthor = authorOptional.get();
            dbAuthor.setName(author.getName());
            dbAuthor.setAbout(author.getAbout());

            authorRepository.save(dbAuthor);
        }
    }

    @Override
    public void deleteAuthor(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            authorRepository.deleteById(id);
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}

