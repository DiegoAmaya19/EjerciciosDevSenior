package com.example.record.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.record.Model.DTO.BookDTO;
import com.example.record.Model.Entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "title", source = "name")
    @Mapping(target = "id", ignore = true)
    Book toEntity(BookDTO bookDTO);
    
    @Mapping(target = "name", source = "title")
    BookDTO toBookDTO(Book book);
    
}