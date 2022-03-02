package com.bookapp.web.controller;

import java.util.List;

import com.bookapp.model.service.BookService;
import com.bookapp.model.service.BookServiceImpl;
import com.bookapp.web.entities.Book;

public class Main {
	public static void main(String[] args) {
		
		
		BookService bookService=new BookServiceImpl();
		List<Book> allBooks = bookService.getAllBooks();
		allBooks.forEach(b->System.out.println(b));
		
		
		
	}
}
