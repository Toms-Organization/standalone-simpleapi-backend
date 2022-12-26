package com.example.bookbackendexample.Services;

import com.example.bookbackendexample.Services.dto.BookDto;
import com.example.bookbackendexample.Util.Converter;
import com.example.bookbackendexample.models.Book;
import com.example.bookbackendexample.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    private final ModelMapper mapper = new ModelMapper();
    private final BookRepository bookRepository;
    private final Converter converter = new Converter();

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<BookDto> getAllBooks(){
        // converter.convertToBookDto(bookRepository.findAll());
        return converter.convertToBookDto(bookRepository.findAll());
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




}
