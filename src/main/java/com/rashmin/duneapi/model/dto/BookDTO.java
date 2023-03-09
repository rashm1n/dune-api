package com.rashmin.duneapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private int id;
    private String name;
    private String author;
    private Year publishedYear;
    private List<String> characters;
    private List<String> films;
    private List<String> appearingPlanets;
}
