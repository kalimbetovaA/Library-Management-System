package kz.iitu.demo.events;

import kz.iitu.demo.entity.Publisher;
import org.springframework.context.ApplicationEvent;

public class PublisherChangeEvent extends ApplicationEvent {

    private Publisher publisher;
    private String changeType;


    public PublisherChangeEvent(Object source, Publisher publisher, String changeType) {
        super(source);
        this.publisher = publisher;
        this.changeType = changeType;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public String getChangeType() {
        return changeType;
    }
}
