package com.SpringBoot.Book_Strore_Management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.Book_Strore_Management.Dto.Book;
import com.SpringBoot.Book_Strore_Management.Repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	

	public Book createBooks(Book book) {
		return repository.save(book);
	}

	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	public Book getBookById(int id) {
		Optional<Book> byId = repository.findById(id);
		if(byId.isPresent()) return byId.get();
		else return null;
	}

	public Book updateBookByid(int id, String title, String publisher, double price, int quantity) {
		Optional<Book> byId = repository.findById(id);
		
		if(byId.isPresent()) {
			Book book = byId.get();
			book.setTitle(title);
			book.setPublisher(publisher);
			book.setPrice(price);
			book.setQuantity(quantity);
			repository.save(book);
			return book;
		}else {
			return null;
		}
	}

	public int deleteBookById(int id) {
		Optional<Book> byId = repository.findById(id);
		if(byId.isPresent()) {
			repository.deleteById(id);
			return 1;
		}else {
			return 0;
		}
	}

	public Book getBookByTitle(String title) {
		return repository.getBookByTitle(title);
	}

	public List<Book> getBookByPrice(double price) {
		return repository.getBookByPrice(price);
	}

}















