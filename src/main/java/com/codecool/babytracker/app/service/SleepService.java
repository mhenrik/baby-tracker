package com.codecool.babytracker.app.service;

import com.codecool.babytracker.app.repository.SleepRepository;
import org.springframework.stereotype.Service;

@Service
public class SleepService {

    private SleepRepository sleepRepository;

    public SleepService(SleepRepository sleepRepository) {
        this.sleepRepository = sleepRepository;
    }
}
