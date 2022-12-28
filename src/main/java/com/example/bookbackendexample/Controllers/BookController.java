package com.example.bookbackendexample.Controllers;

import com.example.bookbackendexample.Services.BookService;
import com.example.bookbackendexample.Services.dto.BookDto;
import com.example.bookbackendexample.models.Book;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@CrossOrigin
@EnableAutoConfiguration
@RestController()
@RequestMapping("/books")
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @Operation(summary = "Get all books in Database.")
    @GetMapping("/")
    public List<BookDto> getAllBooksFromDb(){
        return bookService.getAllBooks();
    }

    @Operation(summary = "Get all books in Database ordered by id.")
    @GetMapping("/id")
    public List<BookDto> getAllBooksFromDbInOrderbyID(){
        return bookService.getAllBooksAndSortById();
    }

    @Operation(summary = "Get one book with unique Id given in the param")
    @GetMapping("/id/{id}")
    public List<BookDto> getBookWithTheId(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @Operation(summary = "Get all books in Database ordered by the author's name.")
    @GetMapping("/author")
    public List<BookDto> getAllBooksSortedByAuthor(){
        return bookService.getAllBooksAndSortedByAuthor();
    }

    @Operation(summary = "Search for a title containing the entered string.")
    @GetMapping("/author/{searchForTitle}")
    public List<BookDto> getAllBooksContainingAuthorStringOrderById(@PathVariable String searchForTitle){
        return bookService.getBooksContainingAuthorStringAndSortById(searchForTitle);
    }
    @Operation(summary = "Get all books in Database ordered by the title.")
    @GetMapping("/title")
    public List<BookDto> getAllBooksSortByTitle(){
        return bookService.getAllBooksSortByTitle();
    }

    @Operation(summary = "Get all books in Database containing the string entered.")
    @GetMapping("/title/{SearchableString}")
    public List<BookDto> getAllBooksContainingTitleStringOrderById(@PathVariable String SearchableString){
        return bookService.getBooksContainingTitleStringAndSortById(SearchableString);
    }

    @Operation(summary = "Get all books in Database ordered by the books price.")
    @GetMapping("/price")
    public List<BookDto> getAllBooksOrderByPrice(){
        return bookService.getBooksOrderByPrice();
    }

    @Operation(summary = "Get all books in Database with a specific price.")
    @GetMapping("/price/{priceValue}")
    public List<BookDto> getAllBooksOrderByPrice(@PathVariable double priceValue){
        return bookService.getBooksWithSpecificPrice(priceValue);
    }

    @Operation(summary = "Get all books in Database within the given price range.")
    @GetMapping("/price/{value1}/{value2}")
    public List<BookDto> getAllBooksBetweenPriceInterval(@PathVariable("value1") double value1, @PathVariable("value2") double value2){
        return bookService.getAllBooksBetweenPriceRange(value1, value2);
    }
    @Operation(summary = "Get all books in Database ordered by the date published.")
    @GetMapping("/published")
    public List<BookDto> getAllBooksByPublishedDate(){
        return bookService.getAllBooksAndSortByPublished();
    }

    @Operation(summary = "Get all books in Database that was written in specific year.")
    @GetMapping("/published/{value1}")
    public List<BookDto> getAllBooksWrittenThatYear(@PathVariable("value1") int value1){
        return bookService.getAllBooksWrittenThisYear(value1);
    }
    @Operation(summary = "Get all books in Database that was written in specific year and month.")
    @GetMapping("/published/{year}/{month}")
    public List<BookDto> getAllBooksWrittenThatMonth(@PathVariable("year") int year, @PathVariable("month") int month){
        return bookService.getAllBooksWrittenThisMonth(year, month);
    }

    @Operation(summary = "Get all books in Database that was written in specific year/month/day.")
    @GetMapping("/published/{year}/{month}/{day}")
    public List<BookDto> getAllBooksWrittenThatMonth(
            @PathVariable("year") int year,
            @PathVariable("month") int month,
            @PathVariable("day") int day){
        return bookService.getAllBooksWrittenOnDay(year, month, day);
    }
    @Operation(summary = "Updates a book with the id on the url with the RequestBody given.")
    @PostMapping("/update/{id}")
    public ResponseEntity<Book> updateBookById(@RequestBody BookDto bookDto, @PathVariable("id") int id){
        Book book = bookService.updateBookInDataBase(bookDto, id);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
    @Operation(summary = "Creates a new book with the RequestBody given.")
    @PostMapping("/create")
    public ResponseEntity<Book> updateBookById(@RequestBody BookDto bookDto){
        Book book = bookService.createBookInDataBase(bookDto);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
}
