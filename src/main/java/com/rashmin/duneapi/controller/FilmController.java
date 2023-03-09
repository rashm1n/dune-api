package com.rashmin.duneapi.controller;

import com.rashm1n.duneapi.api.FilmsApi;
import com.rashmin.duneapi.exceptions.EntityNotFoundException;
import com.rashmin.duneapi.model.dto.FilmDTO;
import com.rashmin.duneapi.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FilmController implements FilmsApi {
    private FilmService filmService;
    @Override
    public ResponseEntity<List<FilmDTO>> filmsGet() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    @Override
    public ResponseEntity<FilmDTO> filmsIdGet(Integer id) throws EntityNotFoundException {
        return ResponseEntity.ok(filmService.getFilmById(id));
    }
}
