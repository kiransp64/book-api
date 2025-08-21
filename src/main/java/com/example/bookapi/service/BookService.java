package com.example.bookapi.service;

import com.example.bookapi.BookApiApplication;
import com.example.bookapi.dto.BookRequest;
import com.example.bookapi.exception.NotFoundException;
import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {

    private final BookApiApplication bookApiApplication;

    private final BookRepository repo;

    public BookService(BookRepository repo, BookApiApplication bookApiApplication) {
        this.bookApiApplication = bookApiApplication;
        this.repo = repo;
    }

    public Page<Book> list(int page, int size, String sortBy, String dir) {
        Sort sort = Sort.by(Sort.Direction.fromString(dir), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return repo.findAll(pageable);
    }

    public Book get(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Book not found: " + id));
    }

    public Book create(BookRequest req) {
        Book b = new Book();
        b.setTitle(req.getTitle());
        b.setAuthor(req.getAuthor());
        b.setIsbn(req.getIsbn());
        b.setPrice(req.getPrice());
        return repo.save(b);
    }

    public Book update(Long id, BookRequest req) {
        Book b = get(id);
        b.setTitle(req.getTitle());
        b.setAuthor(req.getAuthor());
        b.setIsbn(req.getIsbn());
        b.setPrice(req.getPrice());
        return repo.save(b);
    }

    public void delete(Long id) {
        Book b = get(id);
        repo.delete(b);
    }

	public Book findById(Long id) {
		
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Book not found: " + id));

	}
}
