package com.example.bookbackendexample.repositories;

import com.example.bookbackendexample.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAll();

    List<Book> findAllByTitleContainingIgnoreCase(String searchWord);

    List<Book> findAllById(int id);

    List<Book> findAllByAuthorContainingIgnoreCase(String searchWord);

    List<Book> findAllByPrice(double price);

    List<Book> findAllByPriceBetween(double val1, double val2);

    List<Book> findAllByWrittenBetween(LocalDate dateOne, LocalDate dateTwo);
    List<Book> findAllByWritten(LocalDate date);

}
