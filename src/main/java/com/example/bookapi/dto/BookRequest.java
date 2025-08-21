package com.example.bookapi.dto;

import jakarta.validation.constraints.*;

public class BookRequest {

    @NotBlank(message = "title is required")
    @Size(max = 200)
    private String title;

    @NotBlank(message = "author is required")
    @Size(max = 120)
    private String author;

    @Size(max = 13, message = "isbn must be <= 13 chars")
    private String isbn;

    @Positive(message = "price must be positive")
    private Double price;

    // getters & setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
