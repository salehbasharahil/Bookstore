package com.dxc.bookstore.domain;

import java.util.List;

public record Book(String isbn, String title, int year, double price, String genre, List<Author> authors) {
}
