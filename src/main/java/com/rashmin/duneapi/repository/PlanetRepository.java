package com.rashmin.duneapi.repository;

import com.rashmin.duneapi.model.PlanetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<PlanetEntity, Integer> {
}
