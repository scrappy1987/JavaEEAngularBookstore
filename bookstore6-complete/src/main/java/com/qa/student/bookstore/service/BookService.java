package com.qa.student.bookstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.qa.bookstore.model.Book;
import com.qa.bookstore.util.JSONUtil;

@ApplicationScoped
public class BookService {

	private final int INITIAL_COUNT = 1;
	private Map<Integer, Book> bookMap;
	private int ID;

	@Inject
	private JSONUtil util;

	public BookService() {
		this.bookMap = new HashMap<Integer, Book>();
		ID = INITIAL_COUNT;
		initBookStore();
	}

	public String getAllBooks() {
		return util.getJSONForObject(bookMap);
	}

	public String addNewBook(String bookJson) {
		ID++;
		Book newBook = util.getObjectForJSON(bookJson, Book.class);
		bookMap.put(ID, newBook);
		return bookJson;
	}

	private void initBookStore() {
		Book aBook = new Book("James Herbert", "Rats", "Horror", "1988");
		bookMap.put(1, aBook);
	}

}
