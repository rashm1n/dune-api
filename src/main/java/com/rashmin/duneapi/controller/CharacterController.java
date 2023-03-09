package com.rashmin.duneapi.controller;

import com.rashm1n.duneapi.api.CharactersApi;
import com.rashmin.duneapi.exceptions.EntityNotFoundException;
import com.rashmin.duneapi.model.dto.CharacterDTO;
import com.rashmin.duneapi.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CharacterController implements CharactersApi {
    private CharacterService characterService;
    @Override
    public ResponseEntity<List<CharacterDTO>> charactersGet() {
        return ResponseEntity.ok(characterService.getAllCharacters());
    }

    @Override
    public ResponseEntity<CharacterDTO> charactersIdGet(Integer id) throws EntityNotFoundException {
        return ResponseEntity.ok(characterService.getCharacterById(id));
    }
}
