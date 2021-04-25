package kz.iitu.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.demo.entity.*;
import kz.iitu.demo.service.AuthorService;
import kz.iitu.demo.service.BookService;
import kz.iitu.demo.service.CategoryService;
import kz.iitu.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
@Api(value = "Book Controller", description = "Book Controller allows to work with Book object")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "To get all Books from the database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("")
    public List<Book> getAll() {
        return bookService.findAllBooks();
    }

    @ApiOperation(value = "To get specific Book by its Id", response = Book.class)
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Book object"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public Book findBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @ApiOperation(value = "To search Books using the keyword", response = List.class)
    @GetMapping("/search/")
    public List<Book> searchBooks(@RequestParam String keyword) {
        return bookService.searchBooks(keyword);
    }

    @ApiOperation(value = "To Create a new Book to the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @PostMapping("")
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book);
    }

    @ApiOperation(value = "To Update a specific Book data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @ApiOperation(value = "To Delete a Book")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @ApiOperation(value = "To add publisher to the Book")
    @PatchMapping("/{id}/publisher/{publisherId}")
    public void addPublisher(@PathVariable Long id, @PathVariable Long publisherId) {
        Publisher publisher = publisherService.findPublisherById(publisherId);
        Book book = bookService.findBookById(id);
        book.setPublisher(publisher);
        bookService.updateBook(id, book);
    }

    @ApiOperation(value = "To add author to the Book")
    @PatchMapping("/{id}/authors/{authorId}")
    public void addAuthor(@PathVariable Long id, @PathVariable Long authorId) {
        Author author = authorService.findAuthorById(authorId);
        Book book = bookService.findBookById(id);
        book.getAuthors().add(author);
        bookService.updateBook(id, book);
    }

    @ApiOperation(value = "To add category to the Book")
    @PatchMapping("/{id}/categories/{categoryId}")
    public void addCategory(@PathVariable Long id, @PathVariable Long categoryId) {
        Category category = categoryService.findCategoryById(categoryId);
        Book book = bookService.findBookById(id);
        book.getCategories().add(category);
        bookService.updateBook(id, book);
    }

    @ApiOperation(value = "To delete category from the Book")
    @DeleteMapping("/{id}/category/{categoryId}")
    public void deleteCategory(@PathVariable Long id, @PathVariable Long categoryId) {
        Category category = categoryService.findCategoryById(categoryId);
        Book book = bookService.findBookById(id);
        book.getCategories().remove(category);
        bookService.updateBook(id, book);
    }

    @ApiOperation(value = "To delete author from the Book")
    @DeleteMapping("/{id}/author/{authorId}")
    public void deleteAuthor(@PathVariable Long id, @PathVariable Long authorId) {
        Author author = authorService.findAuthorById(authorId);
        Book book = bookService.findBookById(id);
        book.getAuthors().remove(author);
        bookService.updateBook(id, book);
    }
}
