package com.rashmin.duneapi.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class CharacterDTO {
    private int id;
    private String name;
    private List<String> appearsIn;
    private List<String> films;

}
