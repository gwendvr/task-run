package com.task.task_run.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.task_run.model.Badge;
import com.task.task_run.service.BadgeService;

@RestController
@RequestMapping("/badges")
public class BadgeController {

    private final BadgeService badgeService;

    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @GetMapping
    public List<Badge> recupererTout() {
        return badgeService.recoverAll();
    }

    @PostMapping
    public Badge creer(@RequestBody Badge badge) {
        return badgeService.create(badge);
    }
}