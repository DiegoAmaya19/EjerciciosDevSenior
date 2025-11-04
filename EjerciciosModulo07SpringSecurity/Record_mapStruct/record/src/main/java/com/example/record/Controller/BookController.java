package com.example.record.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.record.Model.DTO.BookDTO;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<BookDTO> books = new ArrayList<>();

    public BookController(){
        this.books = new ArrayList<>();

        books.add(new BookDTO("Quijote de la mancha", "Juan","Habla de un Don Loco"));
        books.add(new BookDTO("El hombre mas rico de babilonia","Thom Jan","Mejora de tu economia"));
        books.add(new BookDTO("Dorian Grey","Alfonso de Juanes","Historia de autocuidado y horror "));
    }

    @GetMapping("/getBooks")
    public List<BookDTO> getAllBooks(){
        return books;
    }

    @GetMapping("/{title}")
    public BookDTO getBookByTitle(@PathVariable String title){

        return books.stream()
                .filter(b -> b.title().equals(title))
                .findFirst()
                .orElse(null);
    }
   
    @PostMapping("/postBooks")
    public BookDTO createBook(@RequestBody BookDTO entity){
        books.add(entity);

        return entity;
    }
}
