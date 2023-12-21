package com.arm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arm.entity.MyBookList;
import com.arm.repository.IMyBookRepository;

@Service
public class MyBookListService {
	@Autowired
	private IMyBookRepository repository;

	public void saveMyBook(MyBookList bookList) {
		repository.save(bookList);
	}
	
	public List<MyBookList> getAllMyBooks() {
		return repository.findAll();
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
}
