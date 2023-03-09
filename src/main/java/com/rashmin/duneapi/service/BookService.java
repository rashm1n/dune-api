package com.rashmin.duneapi.service;

import com.rashmin.duneapi.exceptions.EntityNotFoundException;
import com.rashmin.duneapi.model.BookEntity;
import com.rashmin.duneapi.model.dto.BookDTO;
import com.rashmin.duneapi.repository.BookRepository;
import com.rashmin.duneapi.util.ApiMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDTO getBookById(int id) throws EntityNotFoundException {
        Optional<BookEntity> bookEntity = bookRepository.findById(id);
        if (!bookEntity.isEmpty()) {
            System.out.println(bookEntity.get().getFilms().isEmpty());
            return ApiMapper.bookMapper(bookEntity.get());
        } else {
            throw new EntityNotFoundException("Book with the id "+id+" not found. Please try again with a valid id.");
        }
    }

    public List<BookDTO> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookEntities.stream().map(ApiMapper::bookMapper).toList();
    }
}
