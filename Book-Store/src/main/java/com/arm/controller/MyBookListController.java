package com.arm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arm.service.MyBookListService;

@Controller
public class MyBookListController {
	@Autowired
	private MyBookListService myService;

	@GetMapping("/delete_my_list/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		myService.deleteById(id);
		return "redirect:/my_books";
	}
}
