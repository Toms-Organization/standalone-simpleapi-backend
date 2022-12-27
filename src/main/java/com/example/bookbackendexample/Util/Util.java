package com.example.bookbackendexample.Util;

import com.example.bookbackendexample.Services.dto.BookDto;
import com.example.bookbackendexample.models.Book;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Util {


    public Util() {
    }



    public List<Book> sortAListById(List<Book> listToSort) {
        List<Book> sortedList = listToSort.stream()
                .sorted(Comparator.comparing(Book::getId))
                .collect(Collectors.toList());
        return sortedList;
    }

    public List<Book> sortAListByAuthor(List<Book> listToSort) {
        List<Book> sortedList = listToSort.stream()
                .sorted(Comparator.comparing(Book::getAuthor))
                .collect(Collectors.toList());
        return sortedList;
    }

    public List<Book> sortAListByTitle(List<Book> listToSort) {
        List<Book> sortedList = listToSort.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
        return sortedList;
    }

    public List<Book> sortByPrice(List<Book> listToSort) {
        List<Book> sortedList = listToSort.stream()
                .sorted(Comparator.comparing(Book::getPrice))
                .collect(Collectors.toList());
        return sortedList;
    }

    public List<Book> sortByDatePublished(List<Book> listToSort) {
        List<Book> sortedList = listToSort.stream()
                .sorted(Comparator.comparing(Book::getWritten))
                .collect(Collectors.toList());
        return sortedList;
    }

    public Book createANewBook(BookDto bookDto) {
        return new Book(null, bookDto.getAuthor(), bookDto.getTitle(), bookDto.getGenre(), bookDto.getPrice(), bookDto.getWritten(), bookDto.getDescription());
    }
    public Book updateABookObject(Book book, BookDto bookDto) {
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setGenre(bookDto.getGenre());
        book.setPrice(bookDto.getPrice());
        book.setWritten(bookDto.getWritten());
        book.setDescription(bookDto.getDescription());
        return book;
    }

}

