package com.example.record.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.record.Model.Entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
    // BookDTO findByTitle(String t);
    Optional<Book> findByTitle(String t);
}
