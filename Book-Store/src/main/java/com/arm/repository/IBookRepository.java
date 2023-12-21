package com.arm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arm.entity.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {

}
