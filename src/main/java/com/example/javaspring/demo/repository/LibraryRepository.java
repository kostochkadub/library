package com.example.javaspring.demo.repository;

import com.example.javaspring.demo.model.Book;
import com.example.javaspring.demo.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

    List<Library> findLibraryById(Integer id);


}
