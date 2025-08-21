package com.example.bookapi.controller;

import com.example.bookapi.dto.BookRequest;
import com.example.bookapi.dto.BookResponseDTO;
import com.example.bookapi.mapper.BookMapper;
import com.example.bookapi.model.Book;
import com.example.bookapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) { this.service = service; }
    

    // List with paging/sorting: /api/books?page=0&size=10&sortBy=title&dir=ASC
    @GetMapping
    public Page<Book> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") String dir) {
        return service.list(page, size, sortBy, dir);
    }

    @GetMapping("/{id}")
    public BookResponseDTO get(@PathVariable Long id) {
    	  Book book = service.findById(id);
    	    return BookMapper.INSTANCE.toDto(book);
    }

    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody BookRequest req) {
        Book created = service.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @Valid @RequestBody BookRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
