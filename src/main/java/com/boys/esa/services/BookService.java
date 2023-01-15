package com.boys.esa.services;

import com.boys.esa.aspects.Logging;
import com.boys.esa.models.Book;
import com.boys.esa.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookService {

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private final BookRepository bookRepository;

    public List<String> getBookList(BookRepository bookRepository) {
        List<String> bookList = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            bookList.add(book.getName());
        }
        return bookList;
    }

    @Logging
    public void delete(Book book) {
        bookRepository.delete(book);
    }
}
