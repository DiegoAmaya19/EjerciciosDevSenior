package com.example.record.Service;

import java.util.List;

import com.example.record.Model.DTO.BookDTO;

public interface BookService {
    BookDTO create(BookDTO book);
    List<BookDTO> getAll();
    BookDTO findByTitle(String title);
}
