package com.rashmin.duneapi.model.dto;

import lombok.Data;

@Data
public class QuoteDTO {
    private int id;
    private String quote;
    private String saidBy;
    private String  appearsIn;
}
