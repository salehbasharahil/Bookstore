package com.dxc.bookstore.service;

import com.dxc.bookstore.domain.Book;
import com.dxc.bookstore.exception.BookAlreadyExistException;
import com.dxc.bookstore.exception.BookNotFoundException;
import com.dxc.bookstore.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Book addNewBook(Book book) {
        if (inventoryRepository.existsById(book.getIsbn())) {
            throw new BookAlreadyExistException();
        }
        return inventoryRepository.save(book);
    }

    public Book updateBook(String isbn, Book book) {
        Book existing = inventoryRepository.findById(isbn)
                .orElseThrow(() -> new BookNotFoundException());

        existing.setTitle(book.getTitle());
        existing.setAuthors(book.getAuthors());
        existing.setYear(book.getYear());
        existing.setPrice(book.getPrice());
        existing.setGenre(book.getGenre());

        return inventoryRepository.save(existing);
    }

    public List<Book> search(String title, String author) {

        if (title != null && author != null) {
            return inventoryRepository.findByTitleAndAuthorName(title, author);
        } else if (title != null) {
            return inventoryRepository.findByTitle(title);
        } else if (author != null) {
            return inventoryRepository.findByAuthorName(author);
        } else {
            return inventoryRepository.findAll();
        }
    }

    public void deleteBook(String isbn) {
        if (!inventoryRepository.existsById(isbn)) {
            throw new BookNotFoundException();
        }
        inventoryRepository.deleteById(isbn);
    }
}