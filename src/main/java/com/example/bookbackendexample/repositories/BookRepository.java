package com.example.bookbackendexample.repositories;

import com.example.bookbackendexample.models.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

      List<Book> findAll();
      List<Book> findBookByAuthor(String name);
//    List<Book> findAll();
//    List<Book> findByName(String name);
//    List<Book> findByNumber(int number);
//    List<Book> findByNameAndNumber(String name, int number);


}
