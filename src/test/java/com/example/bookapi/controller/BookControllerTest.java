package com.example.bookapi.controller;

import com.example.bookapi.dto.BookRequest;
import com.example.bookapi.model.Book;
import com.example.bookapi.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService service;

    @Test
    void getBook_ok() throws Exception {
        Book b = new Book();
        b.setId(1L); b.setTitle("T"); b.setAuthor("A");
        Mockito.when(service.get(1L)).thenReturn(b);

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("T"))
                .andExpect(jsonPath("$.author").value("A"));
    }
}
