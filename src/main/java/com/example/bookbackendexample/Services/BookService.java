package com.example.bookbackendexample.Services;

import com.example.bookbackendexample.Services.dto.BookDto;
import com.example.bookbackendexample.Util.Converter;
import com.example.bookbackendexample.Util.Util;
import com.example.bookbackendexample.models.Book;
import com.example.bookbackendexample.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final Util util = new Util();
    private final ModelMapper mapper = new ModelMapper();
    private final BookRepository bookRepository;
    private final Converter converter = new Converter();

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getAllBooks(){
        return converter.convertToBookDto(bookRepository.findAll());
    }

    public List<BookDto> getAllBooksAndSortById() {
        List<Book> listOfBooksSortedById = util.sortAListById(bookRepository.findAll());
        return converter.convertToBookDto(listOfBooksSortedById);
    }



    public List<BookDto> getBooksContainingTitleStringAndSortById(String SearchableString) {
        List<Book> listOfBooksBySearch = util.sortAListById(bookRepository.findAllByTitleContainingIgnoreCase(SearchableString));
        return converter.convertToBookDto(listOfBooksBySearch);
    }

    /**
     * @param id
     * @return returns just one book with the specific id.
     */
    public List<BookDto> getBookById(int id) {
        List<Book> listOfBooksBySearch = util.sortAListById(bookRepository.findAllById(id));
        return converter.convertToBookDto(listOfBooksBySearch);
    }

    public List<BookDto> getBooksContainingAuthorStringAndSortById(String SearchableString) {
        List<Book> listOfBooksBySearch = util.sortAListById(bookRepository.findAllByAuthorContainingIgnoreCase(SearchableString));
        return converter.convertToBookDto(listOfBooksBySearch);
    }

    public List<BookDto> getAllBooksAndSortedByAuthor() {
        List<Book> listOfBooksSortedByAuthor= util.sortAListByAuthor(bookRepository.findAll());
        return converter.convertToBookDto(listOfBooksSortedByAuthor);

    }
    public Book getBook(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    public BookDto getBook2(Integer id) {
        Book bookA = bookRepository.findById(id).orElse(null);
        if(bookA!=null){
            BookDto dto = mapper.map(bookA, BookDto.class);
            return dto;
        }else{
            return null;
        }
    }


    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


}
