package com.example.record.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.record.Model.Entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
    
}
