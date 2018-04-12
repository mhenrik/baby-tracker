package com.codecool.babytracker.app.repository;

import com.codecool.babytracker.app.model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {

}
