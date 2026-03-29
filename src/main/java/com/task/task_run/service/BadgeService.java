package com.task.task_run.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.task.task_run.model.Badge;
import com.task.task_run.repository.BadgeRepository;

@Service
public class BadgeService {

    private final BadgeRepository badgeRepository;

    public BadgeService(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    public List<Badge> recoverAll() {
        return badgeRepository.findAll();
    }

    public Badge create(Badge badge) {
        return badgeRepository.save(badge);
    }
}