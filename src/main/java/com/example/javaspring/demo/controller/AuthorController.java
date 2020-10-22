package com.example.javaspring.demo.controller;


import com.example.javaspring.demo.model.Author;
import com.example.javaspring.demo.repository.AuthorRepository;
import com.example.javaspring.demo.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public AuthorController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/generateAuthor")
    public Author generate(){
        Author author = new Author();
        author.setName("Artur");

        Author save = authorRepository.save(author);

        return save;
    }

    @GetMapping("/author")
    public List<Author> getAll(){
        return authorRepository.findAll();

    }

    @GetMapping("/author/book/{bookId}")
    public Author getByBookId(@PathVariable Integer bookId){
        return authorRepository.findByBooks(bookId);

    }
}
