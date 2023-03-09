package com.rashmin.duneapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "films")
@Table(name = "films")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmEntity {
    @Id
    private int id;
    private String name;
    private String director;
    @ManyToMany(mappedBy = "appearingFilms")
    private List<CharacterEntity> appearingCharacters;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;
}
