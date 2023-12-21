package com.arm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.arm.entity.Book;
import com.arm.entity.MyBookList;
import com.arm.service.BookService;
import com.arm.service.MyBookListService;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@Autowired
	private MyBookListService myBookService;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/register_book")
	public String registerBook() {
		return "bookRegister";
	}

	@GetMapping("/available_book")
	public ModelAndView getAllBooks() {
		List<Book> books = service.getAll();
		return new ModelAndView("bookList", "book", books);
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_book";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> allMyBooks = myBookService.getAllMyBooks();
		model.addAttribute("books", allMyBooks);
		return "myBooks";
	}

	@GetMapping("/mylist/{id}")
	public String getMyBookList(@PathVariable("id") int id) {
		Book book = service.getBookId(id);
		MyBookList list = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
		myBookService.saveMyBook(list);
		return "redirect:/my_books";
	}

	@GetMapping("/edit_book/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book book = service.getBookId(id);
		model.addAttribute("book", book);
		return "bookEdit";
	}
	@GetMapping("/delete_book/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/available_book";
	}

}
