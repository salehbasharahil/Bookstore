package com.dxc.bookstore.repository;

import com.dxc.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Book,String> {

    List<Book> findByTitle(String title);

    @Query("SELECT b FROM Book b JOIN b.authors a WHERE a.name = :name")
    List<Book> findByAuthorName(@Param("name") String name);

    @Query("SELECT b FROM Book b JOIN b.authors a WHERE b.title = :title AND a.name = :name")
    List<Book> findByTitleAndAuthorName(@Param("title") String title,
                                        @Param("name") String name);
}