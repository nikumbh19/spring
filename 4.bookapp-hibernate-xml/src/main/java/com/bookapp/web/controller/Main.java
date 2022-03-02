package com.bookapp.web.controller;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.bookapp.model.service.BookService;
import com.bookapp.model.service.BookServiceImpl;
import com.bookapp.web.entities.Book;

public class Main{
	public static void main(String[] args) {		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		BookService bookService = ctx.getBean("bookService",BookService.class);
		
		Book book1=new Book("AAA", "Life Part1", "Himanshu", 120);
		Book book2=new Book("BBB", "Life Part2", "Priyanka", 130);
		Book book3=new Book("CCC", "Life Part3", "Pallavi", 140);
		
//		Adding book
//		bookService.addBook(book1);
//		bookService.addBook(book2);
//		bookService.addBook(book3);
		
		
		//Printing all books
		List<Book> allBooks = bookService.getAllBooks();
		allBooks.forEach(book->System.out.println(book));
		
		//Testing deletion
//		bookService.deleteBook(1);
//		allBooks = bookService.getAllBooks();
//		allBooks.forEach(book->System.out.println(book));

		//Testing updation
//		bookService.updateBook(2, book3);
//		allBooks = bookService.getAllBooks();
//		allBooks.forEach(book->System.out.println(book));
		
	}
}
