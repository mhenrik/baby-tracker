package com.codecool.babytracker.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "nappy")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Nappy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private NappyType type;

    @Column(name = "datetime")
    private LocalDateTime dateTime;

    @Column(name = "totalnrofnappies")
    private int totalNrOfNappies;

    @ManyToOne
    private Baby baby;

    public Nappy() {
    }

    public Nappy(NappyType type, Baby baby) {
        this.type = type;
        this.dateTime = LocalDateTime.now();
        this.baby = baby;
    }

    public NappyType getType() {
        return type;
    }

    public void setType(NappyType type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getTotalNrOfNappies() {
        return totalNrOfNappies;
    }

    public void setTotalNrOfNappies(int totalNrOfNappies) {
        this.totalNrOfNappies = totalNrOfNappies;
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
