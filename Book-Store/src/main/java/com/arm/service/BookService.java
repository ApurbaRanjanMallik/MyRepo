package com.arm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arm.entity.Book;
import com.arm.repository.IBookRepository;

@Service
public class BookService {

	@Autowired
	private IBookRepository repository;

	public void save(Book book) {
		repository.save(book);
	}

	public List<Book> getAll() {
		return repository.findAll();
	}

	public Book getBookId(int id) {
		Book book = repository.findById(id).get();
		return book;

	}
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	
}
