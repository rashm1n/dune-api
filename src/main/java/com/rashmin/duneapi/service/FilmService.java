package com.rashmin.duneapi.service;

import com.rashmin.duneapi.exceptions.EntityNotFoundException;
import com.rashmin.duneapi.model.FilmEntity;
import com.rashmin.duneapi.model.dto.FilmDTO;
import com.rashmin.duneapi.repository.FilmRepository;
import com.rashmin.duneapi.util.ApiMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FilmService {
    private FilmRepository filmRepository;
    public List<FilmDTO> getAllFilms() {
        return filmRepository.findAll().stream().map(ApiMapper::filmMapper).toList();
    }

    public FilmDTO getFilmById(int id) throws EntityNotFoundException {
        Optional<FilmEntity> filmEntity = filmRepository.findById(id);
        if (!filmEntity.isEmpty()) {
            return ApiMapper.filmMapper(filmEntity.get());
        } else {
            throw new EntityNotFoundException("Film with the id "+id+" not found. Please try again with a valid id.");
        }
    }
}
