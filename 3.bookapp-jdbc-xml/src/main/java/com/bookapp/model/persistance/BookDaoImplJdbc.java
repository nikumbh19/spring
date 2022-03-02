package com.bookapp.model.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bookapp.web.entities.Book;

@Repository
@Primary
public class BookDaoImplJdbc implements BookDao{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Book> getAllBooks() {
		String GET_ALL_BOOKS="select * from book";
		List<Book> books = jdbcTemplate.query(GET_ALL_BOOKS, new BookRowMapper());
		return books;
	}
	
	@Override
	public Book getBookById(int id) {
		String GET_BOOK_ID="select * from book where id=?";
		Book book = jdbcTemplate.queryForObject(GET_BOOK_ID, new BookRowMapper(),id);
		return book;
	}

	@Override
	public Book addBook(Book book) {
		String INSERT_QUERY="insert into book(isbn,title,author,price) values(?,?,?,?)";
		int update = jdbcTemplate.update(INSERT_QUERY,new Object[] {book.getIsbn(),book.getTitle(),book.getAuthor(),book.getPrice()});
		book.setId(update);
		return book;
	}

	@Override
	public void deleteBook(int id) {
		String DELETE_BOOK_ID="delete from book where id=?";
		jdbcTemplate.update(DELETE_BOOK_ID,new Object[] {id});
	}

	@Override
	public void updateBook(int id, Book book) {
		String UPDATE_BOOK_ID="update book set price=? where id=?";
		int update = jdbcTemplate.update(UPDATE_BOOK_ID,new Object[] {book.getPrice(),id});
	}

	
	
}
