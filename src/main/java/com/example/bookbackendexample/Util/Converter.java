package com.example.bookbackendexample.Util;

import com.example.bookbackendexample.Services.dto.BookDto;
import com.example.bookbackendexample.models.Book;
import org.modelmapper.ModelMapper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
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


    public Date getStartDateFromAYear(int year){
        Calendar calendar = new GregorianCalendar();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        Date date = calendar.getTime();
        return date;
    }

    public Date getEndDateFromAYear(int year){
        Calendar calendar = new GregorianCalendar();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date date = calendar.getTime();
        return date;
    }



}
