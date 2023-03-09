package com.rashmin.duneapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "books")
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
 @Id
 @GeneratedValue
 private int id;
 private String name;
 private String author;
 private Year publishedYear;
 @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
 @JoinTable(name = "books_charactors", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "charactor_id"))
 private List<CharacterEntity> characters;
 @OneToMany(mappedBy="book", fetch = FetchType.EAGER)
 private List<FilmEntity> films = new ArrayList<>();
 @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
 @JoinTable(name = "books_planets", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "planet_id"))
 private List<PlanetEntity> planets;

}