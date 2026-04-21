package com.dxc.bookstore.exception;

public class BookAlreadyExistException extends RuntimeException{

    public BookAlreadyExistException(){

        super("Book with ISBN already exists");
    }
}
