package com.example.bookbackendexample.Util;

import com.example.bookbackendexample.Services.dto.BookDto;
import com.example.bookbackendexample.models.Book;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.ZoneId;
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


    public List<Book> convertDtoToBook(List<BookDto> allBooksToConvert) {
        List<Book> convertedList = allBooksToConvert.stream()
                .map(e -> mapper.map(e, Book.class))
                .collect(Collectors.toList());
        return convertedList;
    }

    public Book convertDtoToBook(BookDto bookDto) {
        return mapper.map(bookDto, Book.class);
    }


    public List<LocalDate> getStartAndEndDateForYear(int year){
        List<LocalDate> listOfTwoValues = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date dateOne = calendar.getTime();
        LocalDate localDateOne = dateOne.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        listOfTwoValues.add(localDateOne);

        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(calendar.DAY_OF_MONTH));
        Date dateTwo = calendar.getTime();
        LocalDate localDateTwo = dateTwo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        listOfTwoValues.add(localDateTwo);
        return listOfTwoValues;
    }

    public List<LocalDate> getStartAndEndDateForYearAndMonth(int year ,int month){
        List<LocalDate> listOfTwoValues = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date dateOne = calendar.getTime();
        LocalDate localDateOne = dateOne.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        listOfTwoValues.add(localDateOne);

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(calendar.DAY_OF_MONTH));
        Date dateTwo = calendar.getTime();
        LocalDate localDateTwo = dateTwo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        listOfTwoValues.add(localDateTwo);
        return listOfTwoValues;
    }

    public LocalDate getSpecificDate(int year, int month, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        Date date = calendar.getTime();
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
