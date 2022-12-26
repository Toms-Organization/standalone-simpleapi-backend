package com.example.bookbackendexample.Controllers;

import com.example.bookbackendexample.Services.BookService;
import com.example.bookbackendexample.Services.dto.BookDto;
import com.example.bookbackendexample.models.Book;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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


    @GetMapping("/id/{SearchableString}")
    public List<BookDto> getAllBooksContainingStringInOrderById(@PathVariable String SearchableString){
        return bookService.getBooksContainingStringAndSortById(SearchableString);
    }



    /**
     * @param id
     * @return A single book with matching ID
     * Note that this returns a single object
     * http://localhost:7000/books/book/1
     */
    @GetMapping("/book/{id}")
    public Book getSingleBookWithId(@PathVariable Integer id){
        return bookService.getBook(id);
    }


    /**
     * @return All books from DB in a list
     * http://localhost:7000/books/allbooksInAList
     */
    @GetMapping("/allbooksInAList")
    public List<Book> getAllbookInAList(){
        return bookService.getBooks();
    }


    /**
     * @param id
     * @return A BookDto based on the ID... The Dto holds other values
     * http://localhost:7000/books/booksDto/1
     */
    @GetMapping("/booksDto/{id}")
    public List<BookDto> getSingleBookAsDto(@PathVariable Integer id){
        List<BookDto> returnList = new ArrayList<>();
        if (bookService.getBook2(id) != null) {
            returnList.add(bookService.getBook2(id));
        }
        return returnList;
    }



}
