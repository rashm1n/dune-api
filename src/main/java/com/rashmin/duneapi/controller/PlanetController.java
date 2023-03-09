package com.rashmin.duneapi.controller;

import com.rashm1n.duneapi.api.PlanetsApi;
import com.rashmin.duneapi.exceptions.EntityNotFoundException;
import com.rashmin.duneapi.model.dto.PlanetDTO;
import com.rashmin.duneapi.service.PlanetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlanetController implements PlanetsApi {
    private PlanetService planetService;

    @Override public ResponseEntity<List<PlanetDTO>> planetsGet() {
        return ResponseEntity.ok(planetService.getAllPlanets());
    }

    @Override public ResponseEntity<PlanetDTO> planetsIdGet(Integer id) throws EntityNotFoundException {
        return ResponseEntity.ok(planetService.getPlanetById(id));
    }
}
