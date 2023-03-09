package com.rashmin.duneapi.repository;

import com.rashmin.duneapi.model.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
}
