package com.example.record.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.record.Mapper.BookMapper;
import com.example.record.Model.DTO.BookDTO;
import com.example.record.Repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository repository;
    private final BookMapper mapper;

    public BookServiceImpl(BookRepository repository, BookMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public BookDTO create(BookDTO book) {
        var bookEntity = mapper.toEntity(book);
        bookEntity = repository.save(bookEntity);
        
        return mapper.toBookDTO(bookEntity);
    }

    @Override
    public List<BookDTO> getAll() {

        return repository.findAll().stream()
                    .map(b -> new BookDTO(b.getTitle(),b.getAuthor(),b.getDescripcion()))
                    .toList();
    }

    @Override
    public BookDTO findByTitle(String title) {

        // return repository.findByTitle(title);
        return repository.findByTitle(title)
                .map(mapper::toBookDTO)
                .orElseThrow(() -> new RuntimeException("El libro no se encuentra"));
    }
    
}