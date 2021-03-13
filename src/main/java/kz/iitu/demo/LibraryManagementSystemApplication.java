package kz.iitu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LibraryManagementSystemApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("kz.iitu.demo");
        context.refresh();

        LibraryManagementSystem libraryManagementSystem = context.getBean(LibraryManagementSystem.class);
        libraryManagementSystem.showMenu();
    }

}
