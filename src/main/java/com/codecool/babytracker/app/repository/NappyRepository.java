package com.codecool.babytracker.app.repository;

import com.codecool.babytracker.app.model.Nappy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NappyRepository extends JpaRepository<Nappy, Long> {
}
