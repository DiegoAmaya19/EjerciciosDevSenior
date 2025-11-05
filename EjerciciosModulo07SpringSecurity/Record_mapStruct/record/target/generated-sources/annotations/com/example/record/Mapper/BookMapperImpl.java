package com.example.record.Mapper;

import com.example.record.Model.DTO.BookDTO;
import com.example.record.Model.Entity.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-05T09:44:54-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.44.0.v20251023-0518, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toEntity(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitle( bookDTO.name() );
        book.setAuthor( bookDTO.author() );
        book.setDescripcion( bookDTO.descripcion() );

        return book;
    }

    @Override
    public BookDTO toBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        String name = null;
        String author = null;
        String descripcion = null;

        name = book.getTitle();
        author = book.getAuthor();
        descripcion = book.getDescripcion();

        BookDTO bookDTO = new BookDTO( name, author, descripcion );

        return bookDTO;
    }
}
