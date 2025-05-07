package com.SpringBoot.Book_Strore_Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Book_Strore_Management.Dto.Book;
import com.SpringBoot.Book_Strore_Management.Service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService service;

	@PostMapping("/books")
	public Book createBooks(@RequestBody Book book) {
		return service.createBooks(book);
	}

	@GetMapping("/allbooks")
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}
	
	@GetMapping("/getbook")
	public Book getBookById(@RequestParam int id){
		return service.getBookById(id);
	}
	
	@PutMapping("/books")
	public Book updateBookById(@RequestParam int id, @RequestParam String title, 
			@RequestParam String publisher, @RequestParam double price, @RequestParam int quantity) {
		return service.updateBookByid(id, title, publisher, price, quantity);
	}
	
	@DeleteMapping("/books")
	public String deleteBookById(@RequestParam int id) {
		int n = service.deleteBookById(id);
		if(n==1) {
			return "Book successfully deleted.";
		}else {
			return "Invalid Id Given";
		}
	}
	
	@GetMapping("/booktitle")
	public Book getBookByTitle(@RequestParam String title) {
		return service.getBookByTitle(title);
	}
	
	@GetMapping("/bookprice")
	public List<Book> getBookByPrice(@RequestParam double price){
		return service.getBookByPrice(price);
	}
}

































