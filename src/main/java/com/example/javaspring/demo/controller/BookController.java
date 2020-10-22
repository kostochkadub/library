package com.example.javaspring.demo.controller;


import com.example.javaspring.demo.model.Author;
import com.example.javaspring.demo.model.Book;
import com.example.javaspring.demo.repository.AuthorRepository;
import com.example.javaspring.demo.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BookController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/generateBook")
    public Book generate(){

        Book book = new Book();
        book.setTitle("book1");
        Book book2 = new Book();
        book2.setTitle("book2");

        Author author = new Author();
        author.setName("Artur");
        authorRepository.save(author);

        book.setAuthor(author);
        book2.setAuthor(author);

        Book saveBook = bookRepository.save(book);
        bookRepository.save(book2);

        return saveBook;
    }

    @GetMapping("/book")
    public List<Book> getAll(){
        return bookRepository.findAll();

    }

    @GetMapping("/book/author/{authorId}")
    public List<Book> getBooksByAuthorId(@PathVariable Integer authorId){
        return bookRepository.findBooksByAuthorId(authorId);

    }
}
