package kz.iitu.demo.service;

import kz.iitu.demo.entity.Book;
import kz.iitu.demo.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    public List<Publisher> findAllPublishers();

    public Publisher findPublisherById(Long id);

    public List<Publisher> searchPublishers(String keyword);

    public void createPublisher(Publisher publisher);

    public void updatePublisher(Long id, Publisher publisher);

    public void deletePublisher(Long id);
}
