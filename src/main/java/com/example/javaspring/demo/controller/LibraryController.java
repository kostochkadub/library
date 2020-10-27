package com.example.javaspring.demo.controller;

import com.example.javaspring.demo.model.Author;
import com.example.javaspring.demo.model.Book;
import com.example.javaspring.demo.model.Library;
import com.example.javaspring.demo.model.User;
import com.example.javaspring.demo.repository.AuthorRepository;
import com.example.javaspring.demo.repository.BookRepository;
import com.example.javaspring.demo.repository.LibraryRepository;
import com.example.javaspring.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private LibraryRepository libraryRepository;

    public LibraryController(AuthorRepository authorRepository, BookRepository bookRepository, UserRepository userRepository, LibraryRepository libraryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.libraryRepository = libraryRepository;
    }

    @GetMapping("/generateLibrary")
    public Library generateLibrary(){

        Author author = new Author();
        author.setName("Artur");
        authorRepository.save(author);

        Book book = new Book();
        book.setTitle("book1");

        book.setAuthor(author);
        Book saveBook = bookRepository.save(book);

        User user = new User();
        user.setName("test_user_1");
        User saveUser = userRepository.save(user);

        Library library = new Library();
        library.setBook(saveBook);
        library.setUser(saveUser);
        Library saveLibrary = libraryRepository.save(library);

        return saveLibrary;
    }

    @GetMapping("/library")
    public List<Library> getAll(){
        return libraryRepository.findAll();
    }
}
