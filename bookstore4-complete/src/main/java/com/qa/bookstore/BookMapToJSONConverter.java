package com.qa.bookstore;

import java.util.Map;

import com.google.gson.Gson;

public class BookMapToJSONConverter {
	private Gson gson;

	public BookMapToJSONConverter() {
		this.gson = new Gson();
	}

	public String convertMapToJson(Map<Integer, Book> BookMap) {
		return gson.toJson(BookMap);
	}
}
