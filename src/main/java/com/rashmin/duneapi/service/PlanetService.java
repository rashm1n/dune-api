package com.rashmin.duneapi.service;

import com.rashmin.duneapi.exceptions.EntityNotFoundException;
import com.rashmin.duneapi.model.PlanetEntity;
import com.rashmin.duneapi.model.dto.PlanetDTO;
import com.rashmin.duneapi.repository.PlanetRepository;
import com.rashmin.duneapi.util.ApiMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlanetService {
    private PlanetRepository planetRepository;
    public List<PlanetDTO> getAllPlanets() {
        return planetRepository.findAll().stream().map(ApiMapper::planetMapper).toList();
    }

    public PlanetDTO getPlanetById(int id) throws EntityNotFoundException {
        Optional<PlanetEntity> planetEntity = planetRepository.findById(id);
        if (!planetEntity.isEmpty()) {
            return ApiMapper.planetMapper(planetEntity.get());
        } else {
            throw new EntityNotFoundException("Planet with the id "+id+" not found. Please try again with a valid id.");
        }
    }
}
