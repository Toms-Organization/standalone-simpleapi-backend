package com.example.bookbackendexample.Util;

import com.example.bookbackendexample.models.Book;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Util {





    public Util(){}


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
}
