package com.dxc.bookstore.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    private String isbn;

    private String title;
    private int year;
    private double price;
    private String genre;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Author> authors;
}
