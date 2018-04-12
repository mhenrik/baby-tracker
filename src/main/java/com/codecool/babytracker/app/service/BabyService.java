package com.codecool.babytracker.app.service;

import com.codecool.babytracker.app.model.Baby;
import com.codecool.babytracker.app.repository.BabyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BabyService {

    private BabyRepository babyRepository;

    public BabyService(BabyRepository babyRepository) {
        this.babyRepository = babyRepository;
    }

    public void saveBaby(Baby baby){
        babyRepository.save(baby);
    }

    public void deleteBaby(Baby baby){
        babyRepository.delete(baby);
    }

    public Baby findById(long id){
        return babyRepository.getOne(id);
    }

    public List<Baby> findAll(){
        return babyRepository.findAll();
    }


}
