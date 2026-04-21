package com.dxc.bookstore.service;

import com.dxc.bookstore.domain.Book;

import java.util.List;

public interface IInventoryService {

    Book addNewBook(Book book);

    Book updateBook(String isbn, Book book);

    List<Book> search(String title, String author);

    void deleteBook(String isbn);
}
