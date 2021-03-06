package com.example.javaspring.demo.repository;

import com.example.javaspring.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    //    получить все книги автора с ID;
     List<Book> findBooksByAuthorId(Integer authorId);

}
