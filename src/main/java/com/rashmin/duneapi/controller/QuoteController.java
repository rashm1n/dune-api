package com.rashmin.duneapi.controller;

import com.rashm1n.duneapi.api.QuotesApi;
import com.rashmin.duneapi.model.dto.QuoteDTO;
import com.rashmin.duneapi.service.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class QuoteController implements QuotesApi {
    private QuoteService quoteService;
    @Override public ResponseEntity<List<QuoteDTO>> quotesGet() {
        return ResponseEntity.ok(quoteService.getAllQuotes());
    }

    @Override public ResponseEntity<QuoteDTO> quotesIdGet(Integer id) {
        return ResponseEntity.ok(quoteService.getQuoteById(id));
    }
}
