package com.dxc.bookstore.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(){

        super("Book Not Found");
    }
}
