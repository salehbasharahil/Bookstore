package com.dxc.bookstore.controller;

import com.dxc.bookstore.domain.Book;
import com.dxc.bookstore.service.InventoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class InventoryController {

    private final InventoryServiceImpl inventoryService;

    public InventoryController(InventoryServiceImpl inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
        Book savedBook = inventoryService.addNewBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/update/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn,
                                           @RequestBody Book book) {
        Book updated = inventoryService.updateBook(isbn, book);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {

        List<Book> results = inventoryService.search(title, author);
        return ResponseEntity.ok(results);
    }

    @DeleteMapping("/delete/{isbn}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteBook(@PathVariable String isbn) {
        inventoryService.deleteBook(isbn);
        return ResponseEntity.ok("Successfully deleted");
    }
}
