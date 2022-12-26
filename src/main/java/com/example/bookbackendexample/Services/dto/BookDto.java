package com.example.bookbackendexample.Services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private String author;
    private String title;
    private String genre;
    private double price ;
    private Date written;
    private String description;



}
