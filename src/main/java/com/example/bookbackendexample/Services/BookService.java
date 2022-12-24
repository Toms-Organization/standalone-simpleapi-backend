package com.example.bookbackendexample.Services;

import com.example.bookbackendexample.Services.dto.BookDto;
import com.example.bookbackendexample.models.Book;
import com.example.bookbackendexample.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    private final ModelMapper mapper = new ModelMapper();
    public BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
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
