package com.SpringBoot.Book_Strore_Management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SpringBoot.Book_Strore_Management.Dto.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("select  b from Book b where b.title=?1")
	public Book getBookByTitle(String title);

	
	@Query("select b from Book b where b.price>?1")
	public List<Book> getBookByPrice(double price);

}
