package com.qa.bookstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookServiceTest {

	private BookService bookService;

	@Before
	public void init() {
		setupBookStore();
	}

	@Test
	public void testShouldUpdateABookInTheBookStore() {
		Assert.assertEquals(bookService.getBookMap().get(1).getYearPublished(), "1998");
		Book theMagicCottage = new Book("James Herbert", "The Magic Cottage", "Horror", "1992");
		bookService.updateBook(1, theMagicCottage);
		Assert.assertEquals(bookService.getBookMap().get(1).getYearPublished(), "1992");
	}

	@Test
	public void testTestTheAmountOfGivenGenreInBookStore() {
		Assert.assertEquals(bookService.findAmountOfGivenGenreInBookStore("Horror"), 2);
	}

	private void setupBookStore() {
		Book itTheClown = new Book("Stephen King", "It", "Horror", "1998");
		Book rats = new Book("James Herbert", "Rats", "Horror", "1998");
		bookService = new BookService();
		bookService.addBook(itTheClown);
		bookService.addBook(rats);
	}

}
