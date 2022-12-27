package com.example.bookbackendexample.Controllers;

import com.example.bookbackendexample.Services.BookService;
import com.example.bookbackendexample.Services.dto.BookDto;
import com.example.bookbackendexample.models.Book;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@CrossOrigin
@EnableAutoConfiguration
@RestController
@RequestMapping("/books")
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<BookDto> getAllBooksFromDb(){
        return bookService.getAllBooks();
    }

    @GetMapping("/id")
    public List<BookDto> getAllBooksFromDbInOrderbyID(){
        return bookService.getAllBooksAndSortById();
    }

    /**
     * @param id
     * @return A single book with matching ID
     * Note that this returns a single object
     * http://localhost:7000/books/book/1
     */
    @GetMapping("/id/{id}")
    public List<BookDto> getBookWithTheId(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @GetMapping("/author")
    public List<BookDto> getAllBooksSortedByAuthor(){
        return bookService.getAllBooksAndSortedByAuthor();
    }

    @GetMapping("/author/{SearchableString}")
    public List<BookDto> getAllBooksContainingAuthorStringOrderById(@PathVariable String SearchableString){
        return bookService.getBooksContainingAuthorStringAndSortById(SearchableString);
    }


    @GetMapping("/title")
    public List<BookDto> getAllBooksSortByTitle(){
        return bookService.getAllBooksSortByTitle();
    }

    @GetMapping("/title/{SearchableString}")
    public List<BookDto> getAllBooksContainingTitleStringOrderById(@PathVariable String SearchableString){
        return bookService.getBooksContainingTitleStringAndSortById(SearchableString);
    }

    @GetMapping("/price")
    public List<BookDto> getAllBooksOrderByPrice(){
        return bookService.getBooksOrderByPrice();
    }

    @GetMapping("/price/{priceValue}")
    public List<BookDto> getAllBooksOrderByPrice(@PathVariable double priceValue){
        return bookService.getBooksWithSpecificPrice(priceValue);
    }

    @GetMapping("/price/{value1}/{value2}")
    public List<BookDto> getAllBooksBetweenPriceInterval(@PathVariable("value1") double value1, @PathVariable("value2") double value2){
        return bookService.getAllBooksBetweenPriceRange(value1, value2);
    }


    @GetMapping("/published")
    public List<BookDto> getAllBooksByPublishedDate(){
        return bookService.getAllBooksAndSortByPublished();
    }


    @GetMapping("/published/{value1}")
    public List<BookDto> getAllBooksWrittenThatYear(@PathVariable("value1") int value1){
        return bookService.getAllBooksWrittenThisYear(value1);
    }

    @GetMapping("/published/{year}/{month}")
    public List<BookDto> getAllBooksWrittenThatMonth(@PathVariable("year") int year, @PathVariable("month") int month){
        return bookService.getAllBooksWrittenThisMonth(year, month);
    }






}
