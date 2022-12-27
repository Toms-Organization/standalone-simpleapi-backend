package com.example.bookbackendexample.Services;

import com.example.bookbackendexample.Services.dto.BookDto;
import com.example.bookbackendexample.Util.Converter;
import com.example.bookbackendexample.Util.Util;
import com.example.bookbackendexample.models.Book;
import com.example.bookbackendexample.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

    public List<BookDto> getAllBooksSortByTitle() {
        List<Book> listOfBooksSortedByTitle= util.sortAListByTitle(bookRepository.findAll());
        return converter.convertToBookDto(listOfBooksSortedByTitle);
    }

    public List<BookDto> getBooksOrderByPrice() {
        List<Book> listOfBooksBySearch = util.sortByPrice(bookRepository.findAll());
        return converter.convertToBookDto(listOfBooksBySearch);
    }

    public List<BookDto> getBooksWithSpecificPrice(double priceValue) {
        List<Book> listOfBooksBySearch = bookRepository.findAllByPrice(priceValue);
        return converter.convertToBookDto(listOfBooksBySearch);
    }

    public List<BookDto> getAllBooksBetweenPriceRange(double value1, double value2) {
        List<Book> listOfBooksBySearch = util.sortByPrice(bookRepository.findAllByPriceBetween(value1, value2));
        return converter.convertToBookDto(listOfBooksBySearch);
    }

    public List<BookDto> getAllBooksAndSortByPublished() {
        List<Book> listOfBooksBySearch =  util.sortByDatePublished(bookRepository.findAll());
        return converter.convertToBookDto(listOfBooksBySearch);
    }

    public List<BookDto> getAllBooksWrittenThisYear(int value1) {
        LocalDate startDate = converter.getStartDateFromAYearLocalDate(value1);
        LocalDate endDate = converter.getEndDateFromAYearLocalDate(value1);
        List<Book> listOfBooksBySearch = util.sortByDatePublished(bookRepository.findAllByWrittenBetween(startDate, endDate));
        return converter.convertToBookDto(listOfBooksBySearch);
    }


    public List<BookDto> getAllBooksWrittenThisMonth(int year, int month) {
        LocalDate startDate = converter.getStartDateFromAMonthLocalDate(year, month);
        LocalDate endDate = converter.getEndDateFromAMonthLocalDate(year, month);
        System.out.println(startDate);
        System.out.println(endDate);
        List<Book> listOfBooksBySearch = util.sortByDatePublished(bookRepository.findAllByWrittenBetween(startDate, endDate));
        return converter.convertToBookDto(listOfBooksBySearch);
    }
}
