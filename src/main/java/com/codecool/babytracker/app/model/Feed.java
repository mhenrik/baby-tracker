package com.codecool.babytracker.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "feed")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "feedstart")
    private LocalDateTime start;

    @Column(name = "feedstop")
    private LocalDateTime end;

    @Column(name = "feedduration")
    private Duration duration;

    @Column(name = "totalfeedtimes")
    private int totalFeedTimes;

    @Enumerated(EnumType.STRING)
    private Side side;

    @ManyToOne
    private Baby baby;

    public Feed() {
    }

    public Feed(Side side, Baby baby) {
        this.start = LocalDateTime.now();
        this.side = side;
        this.baby = baby;
        this.totalFeedTimes = 0;
    }

    public void stopFeeding(){
        this.end = LocalDateTime.now();
        this.duration = Duration.between(start, end);
        this.totalFeedTimes += 1;
    }

    public void resetFeeding(){
        this.duration = Duration.ZERO;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public int getTotalFeedTimes() {
        return totalFeedTimes;
    }

    public void setTotalFeedTimes(int totalFeedTimes) {
        this.totalFeedTimes = totalFeedTimes;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
