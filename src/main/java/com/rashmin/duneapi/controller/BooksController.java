package com.rashmin.duneapi.controller;

import com.rashm1n.duneapi.api.BooksApi;
import com.rashmin.duneapi.exceptions.EntityNotFoundException;
import com.rashmin.duneapi.model.dto.BookDTO;
import com.rashmin.duneapi.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BooksController implements BooksApi {
    private BookService bookService;

    @Override
    public ResponseEntity<List<BookDTO>> booksGet() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @Override
    public ResponseEntity<BookDTO> booksIdGet(Integer id) throws EntityNotFoundException {
        BookDTO bookDTOResponse = bookService.getBookById(id);
        return ResponseEntity.ok(bookDTOResponse);
    }
}
