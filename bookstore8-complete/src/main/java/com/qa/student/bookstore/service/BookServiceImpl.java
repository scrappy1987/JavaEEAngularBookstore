package com.qa.student.bookstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.bookstore.model.Book;
import com.qa.bookstore.util.JSONUtil;

@ApplicationScoped
@Alternative
public class BookServiceImpl implements BookService {

	private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class);
	private final int INITIAL_COUNT = 1;
	private Map<Integer, Book> bookMap;
	private int ID;

	@Inject
	private JSONUtil util;

	public BookServiceImpl() {
		this.bookMap = new HashMap<Integer, Book>();
		ID = INITIAL_COUNT;
		initBookStore();
	}

	@Override
	public String getAllBooks() {
		return util.getJSONForObject(bookMap.values());
	}

	@Override
	public String addNewBook(String bookJson) {
		ID++;
		Book newBook = util.getObjectForJSON(bookJson, Book.class);
		LOGGER.info("In add book method about to add to map");
		bookMap.put(ID, newBook);
		LOGGER.info("In add book method book added to map");
		return bookJson;
	}

	@Override
	public String replaceBook(Integer bookId, String updatedBook) {
		Book newBook = util.getObjectForJSON(updatedBook, Book.class);
		bookMap.put(bookId, newBook);
		return updatedBook;
	}

	@Override
	public String deleteBook(Integer bookId) {
		LOGGER.info("In delete book method about to remove book");
		bookMap.remove(bookId);
		LOGGER.info("In delete book method book removed");
		return "{\"message\": \"book sucessfully removed\"}";
	}

	private void initBookStore() {
		Book aBook = new Book("James Herbert", "Rats", "Horror", "1988");
		bookMap.put(1, aBook);
	}

}
