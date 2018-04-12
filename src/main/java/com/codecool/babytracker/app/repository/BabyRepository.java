package com.codecool.babytracker.app.repository;

import com.codecool.babytracker.app.model.Baby;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BabyRepository extends JpaRepository<Baby, Long> {

}
