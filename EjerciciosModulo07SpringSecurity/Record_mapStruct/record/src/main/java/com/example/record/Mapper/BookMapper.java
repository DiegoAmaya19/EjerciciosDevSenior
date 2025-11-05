package com.example.record.Mapper;

import com.example.record.Model.DTO.BookDTO;
import com.example.record.Model.Entity.Book;

public interface BookMapper {

    Book toEntiry(BookDTO dto);

    BookDTO toBookDTO(Book ent);
    
}
