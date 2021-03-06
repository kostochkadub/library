package com.example.javaspring.demo.repository;

import com.example.javaspring.demo.model.Book;
import com.example.javaspring.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

   // List<User> findUserById(Integer id);
}
