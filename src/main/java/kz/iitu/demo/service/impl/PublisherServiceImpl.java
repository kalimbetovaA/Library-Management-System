package kz.iitu.demo.service.impl;

import kz.iitu.demo.entity.Author;
import kz.iitu.demo.entity.Book;
import kz.iitu.demo.entity.Publisher;
import kz.iitu.demo.events.AuthorChangeEvent;
import kz.iitu.demo.events.PublisherChangeEvent;
import kz.iitu.demo.repository.PublisherRepository;
import kz.iitu.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PublisherServiceImpl implements PublisherService, ApplicationEventPublisherAware {

    @Autowired
    private PublisherRepository publisherRepository;

    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findPublisherById(Long id) {
        return publisherRepository.findById(id).get();
    }

    @Override
    public List<Publisher> searchPublishers(String keyword) {
        if (keyword != null) {
            return publisherRepository.search(keyword);
        }
        return publisherRepository.findAll();
    }

    @Override
    public void createPublisher(Publisher publisher) {
        publisherRepository.save(publisher);
        this.eventPublisher.publishEvent(new PublisherChangeEvent(this, publisher, "added"));
    }

    @Override
    public void updatePublisher(Long id, Publisher publisher) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(id);

        if (publisherOptional.isPresent()) {
            Publisher dbPublisher = publisherOptional.get();
            dbPublisher.setName(publisher.getName());
            dbPublisher.setDescription(publisher.getDescription());
            publisherRepository.save(dbPublisher);

            this.eventPublisher.publishEvent(new PublisherChangeEvent(this, publisher, "updated"));
        }
    }

    @Override
    public void deletePublisher(Long id) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(id);
        if (publisherOptional.isPresent()) {
            publisherRepository.deleteById(id);
            this.eventPublisher.publishEvent(new PublisherChangeEvent(this, publisherOptional.get(), "deleted"));
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}

