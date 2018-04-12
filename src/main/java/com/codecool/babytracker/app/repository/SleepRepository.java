package com.codecool.babytracker.app.repository;

import com.codecool.babytracker.app.model.Sleep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SleepRepository extends JpaRepository<Sleep, Long> {
}
