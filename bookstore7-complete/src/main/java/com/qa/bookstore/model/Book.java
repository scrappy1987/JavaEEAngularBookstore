package com.qa.bookstore.model;

public class Book {

	private String author;
	private String title;
	private String genre;
	private String yearPublished;

	public Book(String author, String title, String genre, String yearPublished) {
		this.author = author;
		this.title = title;
		this.genre = genre;
		this.yearPublished = yearPublished;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(String yearPublished) {
		this.yearPublished = yearPublished;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
