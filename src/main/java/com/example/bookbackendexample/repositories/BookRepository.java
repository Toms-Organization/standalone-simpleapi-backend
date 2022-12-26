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
      List<Book> findAllByTitleContainingIgnoreCase(String searchWord);
      List<Book> findAllById(int id);
      List<Book> findAllByAuthorContainingIgnoreCase(String searchWord);




}
