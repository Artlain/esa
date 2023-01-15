package com.boys.esa.restcontroller;

import com.boys.esa.models.Author;
import com.boys.esa.models.Book;
import com.boys.esa.repo.AuthorRepository;
import com.boys.esa.repo.BookRepository;
import com.boys.esa.services.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Response;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest")
public class BookRestController {

    BookService bookService;
    BookRepository bookRepository;
    AuthorRepository authorRepository;

    public BookRestController(BookService bookService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<String>> getBookList() {
        List<String> bookList = bookService.getBookList(bookRepository);

        return bookList != null
                ? new ResponseEntity<>(bookList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/xml/books", produces = MediaType.APPLICATION_XML_VALUE)
    public ModelAndView getXMLBookList() throws JsonProcessingException {
        List<Book> bookList = bookRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("booksbyauthors");
        Source source = new StreamSource(new ByteArrayInputStream(new XmlMapper().writeValueAsBytes(bookList)));
        modelAndView.addObject(source);
        return modelAndView;
    }

    @GetMapping("/authors/{id}/books")
    public ResponseEntity<List<String>> getBookListByAuthor(@PathVariable(value = "id") UUID id) {
        Author author = authorRepository.findById(id).orElseThrow(NullPointerException::new);
        List<Book> bookList = bookRepository.findAllByAuthor(author);
        List<String> bookListByAuthor = bookList.stream().map(Book::getName).collect(Collectors.toList());
        return !bookListByAuthor.isEmpty()
                ? new ResponseEntity<>(bookListByAuthor, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("delete/books/{id}")
    public void deleteBookById(@PathVariable(value = "id") UUID id) {
        Book book = bookRepository.findById(id).orElseThrow(NullPointerException::new);
        bookService.delete(book);
    }

    @GetMapping(value = "/xml/authors/{id}/books", produces = "application/xml")
    public ResponseEntity<List<String>> getXMLBookListByAuthor(@PathVariable(value = "id") UUID id) {
        Author author = authorRepository.findById(id).orElseThrow(NullPointerException::new);
        List<Book> bookList = bookRepository.findAllByAuthor(author);
        List<String> bookListByAuthor = bookList.stream().map(Book::getName).collect(Collectors.toList());
        return !bookListByAuthor.isEmpty()
                ? new ResponseEntity<>(bookListByAuthor, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/authors/books")
    public ResponseEntity<Map<String, List<String>>> getBookListByAuthor() {
        Map<String, List<String>> map = new HashMap<>();
        List<Author> authorList = authorRepository.findAll();
        for (Author author : authorList) {
            List<Book> bookList = bookRepository.findAllByAuthor(author);
            map.put(author.getSurname(), bookList.stream().map(Book::getName).collect(Collectors.toList()));
        }
        return !map.isEmpty()
                ? new ResponseEntity<>(map, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/xml/authors/books", produces = "application/xml")
    public ResponseEntity<Map<String, List<String>>> getXMLBookListByAuthor() {
        Map<String, List<String>> map = new HashMap<>();
        List<Author> authorList = authorRepository.findAll();
        for (Author author : authorList) {
            List<Book> bookList = bookRepository.findAllByAuthor(author);
            map.put(author.getSurname(), bookList.stream().map(Book::getName).collect(Collectors.toList()));
        }
        return !map.isEmpty()
                ? new ResponseEntity<>(map, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
