package com.example.bookbackendexample.Services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class BookDto {

    private String author;
    private String genre;
    private double price ;
    private Date written;
    private String description;


}
