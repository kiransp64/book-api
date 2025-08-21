package com.example.bookapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.bookapi.model.Book;
import com.example.bookapi.dto.BookResponseDTO;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookResponseDTO toDto(Book book);
}
