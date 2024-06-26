package com.bookStore.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.entity.Book;
import com.bookStore.entity.MybookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookService;

import ch.qos.logback.core.model.Model;

import java.util.*;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookService myBookService;
	@GetMapping("/")
	
	public String home() {
		return "home";
	}
	@GetMapping("/book_register")
	public String bookRegister() {
		return"bookRegister";
	}
	@GetMapping("available_books")
	public ModelAndView getAllbook() {
		List<Book>list=service.getAllBook();
//	ModelAndView m=new ModelAndView();
//		m.addObject("book",list);
//		m.setViewName("bookList");
		return new ModelAndView("bookList","book",list);
	}
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		
		service.save(b);
		return "redirect:/available_books";
	}
	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
//		List<MybookList>list=myBookService.getAllMyBooks();
//		model.addAttribute("book",list);
//		return "myBooks";
		List<MybookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MybookList mb=new MybookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b =service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
		
	}
	@RequestMapping("/deleteBook/{id}")
		public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
			return "redirect:/available_books";
		}
	}



