package kz.iitu.demo.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BookChangeEventHandler implements ApplicationListener<BookChangeEvent> {

    @Override
    public void onApplicationEvent(BookChangeEvent bookChangeEvent) {
        System.out.println("-------------------------------");
        System.out.println("BookChangeEventHandler.onApplicationEvent");
        System.out.println("Book event:");
        System.out.println("Change: " +bookChangeEvent.getChangeType()
        +"\nBook:"+bookChangeEvent.getBook().getName());
        System.out.println("-------------------------------");
    }
}
