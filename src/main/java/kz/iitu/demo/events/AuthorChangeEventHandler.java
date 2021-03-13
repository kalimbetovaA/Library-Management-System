package kz.iitu.demo.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AuthorChangeEventHandler implements ApplicationListener<AuthorChangeEvent> {

    @Override
    public void onApplicationEvent(AuthorChangeEvent authorChangeEvent) {
        System.out.println("-------------------------------");
        System.out.println("AuthorChangeEventHandler.onApplicationEvent");
        System.out.println("Author event:");
        System.out.println("Change: " +authorChangeEvent.getChangeType()
        +"\nAuthor:"+authorChangeEvent.getAuthor().getName());
        System.out.println("-------------------------------");
    }
}
