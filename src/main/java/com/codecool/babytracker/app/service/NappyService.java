package com.codecool.babytracker.app.service;

import com.codecool.babytracker.app.repository.NappyRepository;
import org.springframework.stereotype.Service;

@Service
public class NappyService {

    private NappyRepository nappyRepository;

    public NappyService(NappyRepository nappyRepository) {
        this.nappyRepository = nappyRepository;
    }
}
