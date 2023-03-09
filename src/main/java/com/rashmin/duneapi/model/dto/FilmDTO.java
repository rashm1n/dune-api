package com.rashmin.duneapi.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class FilmDTO {
    private int id;
    private String name;
    private String director;
    private String basedOn;
    private List<String> appearingCharacters;
}
