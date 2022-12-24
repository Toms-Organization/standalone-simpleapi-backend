package com.example.bookbackendexample.Controllers;

import com.example.bookbackendexample.Services.BookService;
import com.example.bookbackendexample.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@Component
@CrossOrigin
@EnableAutoConfiguration
@RestController
@RequestMapping("/books")
public class BookController {


    public BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    // http://localhost:7000/books/allbooks
    @GetMapping("/allbooks")
    public String getAllbooks(){
        return bookService.getBooks().toString();
    }

    // http://localhost:7000/books/book/1
    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable Integer id){
        return bookService.getBook(id);
    }

    // http://localhost:7000/books/allbooksList
    @GetMapping("/allbooksList")
    public List<Book> getAllbooksToList(){
        return bookService.getBooks();
    }



}
