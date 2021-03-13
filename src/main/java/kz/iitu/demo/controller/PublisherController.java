package kz.iitu.demo.controller;


import kz.iitu.demo.entity.Author;
import kz.iitu.demo.entity.Publisher;
import kz.iitu.demo.service.AuthorService;
import kz.iitu.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    public List<Publisher> getAll() {
        return publisherService.findAllPublishers();
    }

    public Publisher findPublisherById(Long id) {
        return publisherService.findPublisherById(id);
    }

    public List<Publisher> searchPublishers(String keyword) {
        return publisherService.searchPublishers(keyword);
    }

    public void createPublisher(Publisher publisher) {
        publisherService.createPublisher(publisher);
    }

    public void updatePublisher(Long id, Publisher publisher) {
        publisherService.updatePublisher(id, publisher);
    }

    public void deletePublisher(Long id) {
        publisherService.deletePublisher(id);
    }



}
