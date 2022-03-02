package com.bookapp.model.persistance;

import java.util.List;

import com.bookapp.web.entities.Book;

public interface BookDao {
	public List<Book> getAllBooks();
	public Book addBook(Book book);
	public void deleteBook(int id);
	public void updateBook(int id, Book book);
	public Book getBookById(int id);
}
