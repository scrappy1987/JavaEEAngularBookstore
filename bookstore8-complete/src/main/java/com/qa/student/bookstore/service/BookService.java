package com.qa.student.bookstore.service;

public interface BookService {

	String getAllBooks();

	String addNewBook(String bookJson);

	String replaceBook(Integer bookId, String updatedBook);

	String deleteBook(Integer bookId);

}