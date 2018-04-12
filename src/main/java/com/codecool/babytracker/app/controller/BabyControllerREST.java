package com.codecool.babytracker.app.controller;

import com.codecool.babytracker.app.model.Baby;
import com.codecool.babytracker.app.service.BabyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
public class BabyControllerREST {

    @Autowired
    BabyService babyService;

    public BabyControllerREST(BabyService babyService) {
        this.babyService = babyService;
    }

    @PostMapping(value = "/new-baby", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity newBaby(
            @RequestParam String babyname,
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @RequestParam LocalDate birthday) {
        Baby baby = new Baby(babyname, birthday);
        babyService.saveBaby(baby);
        return ResponseEntity.ok(baby);

    }

    @GetMapping(value = "/baby/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findBaby(@PathVariable(value = "id") Integer id){
        Baby baby = babyService.findById((long) id);
        return ResponseEntity.ok(baby);
    }


}
