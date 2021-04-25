//package kz.iitu.demo;
//
//import kz.iitu.demo.controller.AuthorController;
//import kz.iitu.demo.controller.BookController;
//import kz.iitu.demo.controller.PublisherController;
//import kz.iitu.demo.entity.Author;
//import kz.iitu.demo.entity.Book;
//import kz.iitu.demo.entity.Publisher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Scanner;
//
//@Component
//public class LibraryManagementSystem {
//    Scanner sc=new Scanner(System.in);
//
//    @Autowired
//    AuthorController authorController;
//    @Autowired
//    PublisherController publisherController;
//    @Autowired
//    BookController bookController;
//
//    public void showMenu(){
//
//        while (true) {
//            System.out.println("Choose entity to view all/add/edit/delete/search: ");
//            System.out.println("1 - Book\n" +
//                    "2 - Author\n" +
//                    "3 - Publisher\n" +
//                    "0 - exit");
//            int choice = sc.nextInt();
//            switch (choice){
//                case 1:
//                    bookMenu();
//                    break;
//                case 2:
//                    authorMenu();
//                    break;
//                case 3:
//                    publisherMenu();
//                    break;
//                case 0:
//                    return;
//            }
//        }
//    }
//
//    public void bookMenu(){
//
//        while (true) {
//            System.out.println("What do you want to do with books: ");
//            System.out.println(
//                    "1 - view all\n" +
//                            "2 - add\n" +
//                            "3 - edit\n" +
//                            "4 - delete\n" +
//                            "5 - search\n" +
//                            "0 - exit");
//            int choice = sc.nextInt();
//            List<Book> books=bookController.getAll();
//            List<Author> authors=authorController.findAllAuthors();
//            List<Publisher> publishers=publisherController.getAll();
//            Book book;
//            String printBooks="";
//            switch (choice){
//                case 1:
//                    for (Book b:books) {
//                        printBooks+="\n"+b.getId()+") "+b.getName()+"\n"+b.getDescription()+
//                                "\nbook Author: "+authorController.findAuthorById(b.getAuthor_id()).getName()+
//                                "\nbook Publisher: "+publisherController.findPublisherById(b.getPublisher_id()).getName();
//                    }
//                    System.out.println(printBooks);
//                    break;
//                case 2:
//                    book = new Book();
//                    System.out.println("Enter new book data: ");
//                    System.out.println("Enter name: ");
//                    book.setName(sc.next());
//                    System.out.println("Enter description: ");
//                    book.setDescription(sc.next());
//                    System.out.println("Choose author(enter its id): ");
//                    for (Author a:authors) {
//                        System.out.println(a.getId()+") "+a.getName()+": "+a.getAbout());
//                    }
//                    book.setAuthor_id(sc.nextLong());
//                    System.out.println("Choose publisher(enter its id): ");
//                    for (Publisher p:publishers) {
//                        System.out.println(p.getId()+") "+p.getName()+": "+p.getDescription());
//                    }
//                    book.setPublisher_id(sc.nextLong());
//                    bookController.createBook(book);
//                    System.out.println("Book "+book.getName()+" successfully added!");
//                    break;
//                case 3:
//                    for (Book b:books) {
//                        printBooks+="\n"+b.getId()+") "+b.getName()+"\n"+b.getDescription()+
//                                "\nbook Author: "+authorController.findAuthorById(b.getAuthor_id()).getName()+
//                                "\nbook Publisher: "+publisherController.findPublisherById(b.getPublisher_id()).getName();
//                    }
//                    System.out.println("Choose book(enter its id): ");
//                    System.out.println(printBooks);
//                    Long id = sc.nextLong();
//                    book=bookController.findBookById(id);
//                    System.out.println("Enter new name: ");
//                    book.setName(sc.next());
//                    System.out.println("Enter new description: ");
//                    book.setDescription(sc.next());
//                    System.out.println("Choose author(enter its id): ");
//                    for (Author a:authors) {
//                        System.out.println(a.getId()+") "+a.getName()+": "+a.getAbout());
//                    }
//                    book.setAuthor_id(sc.nextLong());
//                    System.out.println("Choose publisher(enter its id): ");
//                    for (Publisher p:publishers) {
//                        System.out.println(p.getId()+") "+p.getName()+": "+p.getDescription());
//                    }
//                    book.setPublisher_id(sc.nextLong());
//                    bookController.updateBook(id, book);
//                    System.out.println("Book "+book.getName()+" successfully edited!");
//                    break;
//                case 4:
//                    for (Book b:books) {
//                        printBooks+="\n"+b.getId()+") "+b.getName()+"\n"+b.getDescription()+
//                                "\nbook Author: "+authorController.findAuthorById(b.getAuthor_id()).getName()+
//                                "\nbook Publisher: "+publisherController.findPublisherById(b.getPublisher_id()).getName();
//                    }
//                    System.out.println("Choose book(enter its id): ");
//                    System.out.println(printBooks);
//                    bookController.deleteBook(sc.nextLong());
//                    System.out.println("Book successfully deleted!");
//                    break;
//                case 5:
//                    System.out.println("Enter keyword: ");
//                    String keyword=sc.next();
//                    List<Book> resultBooks=bookController.searchBooks(keyword);
//                    System.out.println("Result: ");
//                    for (Book b:resultBooks) {
//                        printBooks+="\n"+b.getId()+") "+b.getName()+"\n"+b.getDescription()+
//                                "\nbook Author: "+authorController.findAuthorById(b.getAuthor_id()).getName()+
//                                "\nbook Publisher: "+publisherController.findPublisherById(b.getPublisher_id()).getName();
//                    }
//                    System.out.println(printBooks);
//                    break;
//                case 0:
//                    return;
//            }
//        }
//    }
//
//    public void authorMenu(){
//
//        while (true) {
//            System.out.println("What do you want to do with authors: ");
//            System.out.println(
//                    "1 - view all\n" +
//                            "2 - add\n" +
//                            "3 - edit\n" +
//                            "4 - delete\n" +
//                            "5 - search\n" +
//                            "0 - exit");
//            int choice = sc.nextInt();
//            List<Author> authors=authorController.findAllAuthors();
//            Author author;
//            switch (choice){
//                case 1:
//                    for (Author a:authors) {
//                        System.out.println(a.toString());
//                    }
//                    break;
//                case 2:
//                    author = new Author();
//                    System.out.println("Enter new author data: ");
//                    System.out.println("Enter name: ");
//                    author.setName(sc.next());
//                    System.out.println("Enter about info: ");
//                    author.setAbout(sc.next());
//                    authorController.createAuthor(author);
//                    System.out.println("Author "+author.getName()+" successfully added!");
//                    break;
//                case 3:
//                    System.out.println("Choose author(enter its id): ");
//                    for (Author a:authors) {
//                        System.out.println(a.toString());
//                    }
//                    Long id = sc.nextLong();
//                    author=authorController.findAuthorById(id);
//                    System.out.println("Enter new name: ");
//                    author.setName(sc.next());
//                    System.out.println("Enter new about info: ");
//                    author.setAbout(sc.next());
//                    authorController.updateAuthor(id, author);
//                    System.out.println("Author "+author.getName()+" successfully edited!");
//                    break;
//                case 4:
//                    System.out.println("Choose author(enter its id): ");
//                    for (Author a:authors) {
//                        System.out.println(a.toString());
//                    }
//                    authorController.deleteAuthor(sc.nextLong());
//                    System.out.println("Author successfully deleted!");
//                    break;
//                case 5:
//                    System.out.println("Enter keyword: ");
//                    String keyword=sc.next();
//                    List<Author> resultAuthors=authorController.searchAuthors(keyword);
//                    System.out.println("Result: ");
//                    for (Author a:resultAuthors) {
//                        System.out.println(a.toString());
//                    }
//                    break;
//                case 0:
//                    return;
//            }
//        }
//    }
//
//    public void publisherMenu(){
//
//        while (true) {
//            System.out.println("What do you want to do with publishers: ");
//            System.out.println(
//                    "1 - view all\n" +
//                    "2 - add\n" +
//                    "3 - edit\n" +
//                    "4 - delete\n" +
//                    "5 - search\n" +
//                    "0 - exit");
//            int choice = sc.nextInt();
//            List<Publisher> publishers=publisherController.getAll();
//            Publisher publisher;
//            switch (choice){
//                case 1:
//                    for (Publisher p:publishers) {
//                        System.out.println(p.toString());
//                    }
//                    break;
//                case 2:
//                    publisher = new Publisher();
//                    System.out.println("Enter new publisher data: ");
//                    System.out.println("Enter name: ");
//                    publisher.setName(sc.next());
//                    System.out.println("Enter description: ");
//                    publisher.setDescription(sc.next());
//                    publisherController.createPublisher(publisher);
//                    System.out.println("Publisher "+publisher.getName()+" successfully added!");
//                    break;
//                case 3:
//                    System.out.println("Choose publisher(enter its id): ");
//                    for (Publisher p:publishers) {
//                        System.out.println(p.toString());
//                    }
//                    Long id = sc.nextLong();
//                    publisher=publisherController.findPublisherById(id);
//                    System.out.println("Enter new name: ");
//                    publisher.setName(sc.next());
//                    System.out.println("Enter new description: ");
//                    publisher.setDescription(sc.next());
//                    publisherController.updatePublisher(id, publisher);
//                    System.out.println("Publisher "+publisher.getName()+" successfully edited!");
//                    break;
//                case 4:
//                    System.out.println("Choose publisher(enter its id): ");
//                    for (Publisher p:publishers) {
//                        System.out.println(p.toString());
//                    }
//                    publisherController.deletePublisher(sc.nextLong());
//                    System.out.println("Publisher successfully deleted!");
//                    break;
//                case 5:
//                    System.out.println("Enter keyword: ");
//                    String keyword=sc.next();
//                    List<Publisher> resultPublishers=publisherController.searchPublishers(keyword);
//                    System.out.println("Result: ");
//                    for (Publisher p:resultPublishers) {
//                        System.out.println(p.toString());
//                    }
//                    break;
//                case 0:
//                    return;
//            }
//        }
//    }
//
//
//
//
//}
