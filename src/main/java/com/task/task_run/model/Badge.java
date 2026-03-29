package com.task.task_run.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private String icone;
    private int xpCondition;
    private int streakCondition;
    private int levelCondition;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getIcone() {
        return icone;
    }
    public void setIcone(String icone) {
        this.icone = icone;
    }
    public int getXpCondition() {
        return xpCondition;
    }
    public void setXpCondition(int xpCondition) {
        this.xpCondition = xpCondition;
    }
    public int getStreakCondition() {
        return streakCondition;
    }
    public void setStreakCondition(int streakCondition) {
        this.streakCondition = streakCondition;
    }
    public int getLevelCondition() {
        return levelCondition;
    }
    public void setLevelCondition(int levelCondition) {
        this.levelCondition = levelCondition;
    }
    
}