package com.rashmin.duneapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "planets")
@Table(name = "planets")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlanetEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToMany(mappedBy = "planets")
    private List<BookEntity> books;

}
