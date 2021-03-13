package kz.iitu.demo.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PublisherChangeEventHandler implements ApplicationListener<PublisherChangeEvent> {

    @Override
    public void onApplicationEvent(PublisherChangeEvent publisherChangeEvent) {
        System.out.println("-------------------------------");
        System.out.println("PublisherChangeEventHandler.onApplicationEvent");
        System.out.println("Publisher event: ");
        System.out.println("Change: " +publisherChangeEvent.getChangeType()
        +"\nPublisher:"+publisherChangeEvent.getPublisher().getName());
        System.out.println("-------------------------------");
    }
}
