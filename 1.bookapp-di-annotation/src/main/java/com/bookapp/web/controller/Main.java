package com.bookapp.web.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.model.service.BookService;
import com.bookapp.model.service.BookServiceImpl;
import com.bookapp.web.entities.Book;

public class Main {
	public static void main(String[] args) {
		
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		BookService bookService = ctx.getBean("bookService",BookService.class);
		List<Book> allBooks = bookService.getAllBooks();
		allBooks.forEach(b->System.out.println(b));
		
		bookService.deleteBook(1);
		System.out.println("--After deleting---");
		allBooks = bookService.getAllBooks();
		allBooks.forEach(b->System.out.println(b));
		
		System.out.println("---After adding----");
		bookService.addBook(new Book("XAM","Life is Beautiful","Himanshu",45.0));
		allBooks = bookService.getAllBooks();
		allBooks.forEach(b->System.out.println(b));
		
	}
}
