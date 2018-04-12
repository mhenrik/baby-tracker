package com.codecool.babytracker.app.controller;

import com.codecool.babytracker.app.model.Baby;
import com.codecool.babytracker.app.model.Feed;
import com.codecool.babytracker.app.model.Side;
import com.codecool.babytracker.app.service.BabyService;
import com.codecool.babytracker.app.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedControllerREST {

    private FeedService feedService;

    private BabyService babyService;

    public FeedControllerREST(FeedService feedService, BabyService babyService) {
        this.feedService = feedService;
        this.babyService = babyService;
    }

    @PostMapping(value = "/startfeed", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity startFeed(
            @RequestParam Side side,
            @RequestParam long babyId){
        Baby baby = babyService.findById(babyId);
        Feed feed = new Feed(side, baby);
        feedService.saveFeed(feed);
        return ResponseEntity.ok(feed);
    }

    @GetMapping(value = "/feed/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findFeed(@PathVariable(value = "id") Integer id){
        Feed feed = feedService.findFeed((long) id);
        return ResponseEntity.ok(feed);
    }

    @PutMapping(value = "/stopfeed/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity stopFeed(
            @PathVariable(value = "id") Integer feedId){
        Feed feed = feedService.findFeed((long)feedId);
        feedService.stopFeed(feed);
        return ResponseEntity.ok(feed);

    }
}
