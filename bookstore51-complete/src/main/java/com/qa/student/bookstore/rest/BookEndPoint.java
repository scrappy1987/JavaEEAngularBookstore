package com.qa.student.bookstore.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.student.bookstore.service.BookService;

@Path("/bookstore")
public class BookEndPoint {

	@Inject
	private BookService bookService;

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getBooksAsJson() {
		return bookService.getAllBooks();
	}

	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addNewBookToMap(String bookJson) {
		return bookService.addNewBook(bookJson);
	}

	@PUT
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String replaceBookFromBookStore(@PathParam("id") Integer id, String bookJson) {
		return bookService.replaceBook(id, bookJson);
	}

	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteBookFromBookStore(@PathParam("id") Integer id) {
		return bookService.deleteBook(id);
	}

}
