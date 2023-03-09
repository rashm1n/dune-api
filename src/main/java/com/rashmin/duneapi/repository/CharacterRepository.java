package com.rashmin.duneapi.repository;

import com.rashmin.duneapi.model.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {
}
