package com.rashmin.duneapi.service;

import com.rashmin.duneapi.exceptions.EntityNotFoundException;
import com.rashmin.duneapi.model.CharacterEntity;
import com.rashmin.duneapi.model.dto.CharacterDTO;
import com.rashmin.duneapi.repository.CharacterRepository;
import com.rashmin.duneapi.util.ApiMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<CharacterDTO> getAllCharacters() {
        return characterRepository.findAll().stream().map(ApiMapper::characterMapper).toList();
    }

    public CharacterDTO getCharacterById(int id) throws EntityNotFoundException {
        Optional<CharacterEntity> characterEntity = characterRepository.findById(id);
        if (!characterEntity.isEmpty()) {
            return ApiMapper.characterMapper(characterEntity.get());
        } else {
            throw new EntityNotFoundException("Character with the id "+id+" not found. Please try again with a valid id.");
        }
    }
}
