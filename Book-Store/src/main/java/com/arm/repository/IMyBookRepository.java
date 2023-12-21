package com.arm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arm.entity.MyBookList;

public interface IMyBookRepository extends JpaRepository<MyBookList, Integer> {

}
