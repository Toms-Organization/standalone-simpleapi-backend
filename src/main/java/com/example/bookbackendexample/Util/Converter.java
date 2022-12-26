package com.example.bookbackendexample.Util;

import com.example.bookbackendexample.Services.dto.BookDto;
import com.example.bookbackendexample.models.Book;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    private final ModelMapper mapper = new ModelMapper();

    public Converter(){
    }

    public List<BookDto> convertToBookDto(List<Book> allBooksToConvert) {
        List<BookDto> convertedList = allBooksToConvert.stream()
                .map(e -> mapper.map(e, BookDto.class))
                .collect(Collectors.toList());
        return convertedList;
    }
}
