package com.codecool.babytracker.app.service;

import com.codecool.babytracker.app.model.Feed;
import com.codecool.babytracker.app.repository.FeedRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedService {

    private FeedRepository feedRepository;

    public FeedService(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public void saveFeed(Feed feed){
        feedRepository.save(feed);
    }

    public Feed findFeed(long feedId){
        return feedRepository.getOne(feedId);
    }

    public void stopFeed(Feed feed){
        feed.stopFeeding();
        feedRepository.save(feed);
    }

    public void deleteFeed(Feed feed){
        feedRepository.delete(feed);
    }

    public long countFeed(){
        return feedRepository.count();
    }
}
