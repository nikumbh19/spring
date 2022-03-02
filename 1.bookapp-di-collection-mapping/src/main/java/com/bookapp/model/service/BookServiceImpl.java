package com.bookapp.model.service;

import java.util.List;

import com.bookapp.model.persistance.BookDao;
import com.bookapp.model.persistance.BookDaoImpl;
import com.bookapp.web.entities.Book;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	public Book addBook(Book book) {
		return bookDao.addBook(book);
	}

	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}

	public void updateBook(int id, Book book) {
		bookDao.updateBook(id, book);
	}

	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

}
