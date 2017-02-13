package com.qa.student.bookstore.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.bookstore.model.Book;
import com.qa.bookstore.util.JSONUtil;

@Stateless
@Default
public class BookServiceDBImpl implements BookService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllBooks() {
		Query query = em.createQuery("SELECT e FROM Book e");
		Collection<Book> books = (Collection<Book>) query.getResultList();
		return util.getJSONForObject(books);
	}

	@Override
	public String addNewBook(String bookJson) {
		Book newBook = util.getObjectForJSON(bookJson, Book.class);
		em.persist(newBook);
		return bookJson;
	}

	@Override
	public String replaceBook(Integer bookId, String updatedBook) {
		Book updateBook = util.getObjectForJSON(updatedBook, Book.class);
		Book book = findBook(new Long(bookId));
		if (book != null) {
			book = updateBook;
			em.merge(book);
		}
		return "{\"message\": \"book sucessfully updated\"}";
	}

	@Override
	public String deleteBook(Integer bookId) {
		Book book = findBook(new Long(bookId));
		if (book != null) {
			em.remove(book);
		}
		return "{\"message\": \"book sucessfully removed\"}";
	}

	private Book findBook(Long id) {
		return em.find(Book.class, id);
	}

}
