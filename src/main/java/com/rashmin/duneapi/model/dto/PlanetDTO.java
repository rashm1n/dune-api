package com.rashmin.duneapi.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PlanetDTO {
    private int id;
    private String name;
    private List<String> books;
}
