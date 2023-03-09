package com.rashmin.duneapi.util;

import com.rashmin.duneapi.model.BookEntity;
import com.rashmin.duneapi.model.CharacterEntity;
import com.rashmin.duneapi.model.FilmEntity;
import com.rashmin.duneapi.model.PlanetEntity;
import com.rashmin.duneapi.model.dto.BookDTO;
import com.rashmin.duneapi.model.dto.CharacterDTO;
import com.rashmin.duneapi.model.dto.FilmDTO;
import com.rashmin.duneapi.model.dto.PlanetDTO;

public class ApiMapper {
    public static BookDTO bookMapper(BookEntity entity) {
        BookDTO dto = new BookDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAuthor(entity.getAuthor());
        dto.setPublishedYear(entity.getPublishedYear());
        dto.setCharacters(entity.getCharacters().stream().map(i -> ApiConstants.BASE_URL + "characters/"+i.getId()).toList());
        dto.setFilms(entity.getFilms().stream().map(i -> ApiConstants.BASE_URL + "films/"+i.getId()).toList());
        dto.setAppearingPlanets(entity.getPlanets().stream().map(i -> ApiConstants.BASE_URL + "planets/"+i.getId()).toList());
        return dto;
    }

    public static CharacterDTO characterMapper(CharacterEntity entity) {
        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAppearsIn(entity.getBooks().stream().map(i -> ApiConstants.BASE_URL + "books/"+i.getId()).toList());
        dto.setFilms(entity.getAppearingFilms().stream().map(i -> ApiConstants.BASE_URL + "films/"+i.getId()).toList());
        return dto;
    }

    public static FilmDTO filmMapper(FilmEntity entity) {
        FilmDTO dto = new FilmDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDirector(entity.getDirector());
        dto.setBasedOn(ApiConstants.BASE_URL + "books/"+entity.getBook().getId());
        dto.setAppearingCharacters(entity.getAppearingCharacters().stream().map(i -> ApiConstants.BASE_URL + "characters/"+i.getId()).toList());
        return dto;
    }

    public static PlanetDTO planetMapper(PlanetEntity entity) {
        PlanetDTO dto = new PlanetDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setBooks(entity.getBooks().stream().map(i -> ApiConstants.BASE_URL + "books/"+i.getId()).toList());
        return dto;
    }
}
