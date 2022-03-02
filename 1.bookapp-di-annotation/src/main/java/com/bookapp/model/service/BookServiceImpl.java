package com.bookapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bookapp.model.persistance.BookDao;
import com.bookapp.model.persistance.BookDaoImpl;
import com.bookapp.web.entities.Book;

@Service(value="bookService")
public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	
	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public BookServiceImpl() {
		this.bookDao = new BookDaoImpl();
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
