package com.rashmin.duneapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "charactors")
@Table(name = "charactors")
@Data
@Getter
@Setter
public class CharacterEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany(mappedBy = "characters")
    private List<BookEntity> books;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "characters_films", joinColumns = @JoinColumn(name = "character_id"), inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<FilmEntity> appearingFilms;
}
