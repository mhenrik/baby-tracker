package com.codecool.babytracker.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "sleep")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sleep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sleepstart")
    private LocalDateTime start;

    @Column(name = "sleepend")
    private LocalDateTime end;

    @Column(name = "sleepduration")
    private Duration duration;

    @Column(name = "totalsleeptime")
    private Duration totalSleepTime;

    @ManyToOne
    private Baby baby;

    public Sleep(Baby baby) {
        this.start = LocalDateTime.now();
        this.baby = baby;
    }

    public void stopSleepint(LocalDateTime date){
        this.end = date;
        this.duration = Duration.between(end, start);
    }

    public Sleep() {
    }

    public void resetSleep(){
        this.duration = Duration.ZERO;
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Duration getTotalSleepTime() {
        return totalSleepTime;
    }

    public void setTotalSleepTime(Duration totalSleepTime) {
        this.totalSleepTime = totalSleepTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }
}
