package com.task.task_run.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.task.task_run.model.Badge;
import com.task.task_run.model.User;
import com.task.task_run.repository.BadgeRepository;
import com.task.task_run.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BadgeRepository badgeRepository;

    public UserService(UserRepository userRepository, BadgeRepository badgeRepository) {
        this.userRepository = userRepository;
        this.badgeRepository = badgeRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User addXp(Long id, int xp) {
        User user = getById(id);
        user.setXp(user.getXp() + xp);
        user.setLevel(levelCheck(user.getXp()));
        updateStreak(user);
        badgesCheck(user);
        return userRepository.save(user);
    }

    private int levelCheck(int xp) {
        if (xp >= 1000) {
            return 5;
        }
        if (xp >= 500) {
            return 4;
        }
        if (xp >= 200) {
            return 3;
        }
        if (xp >= 100) {
            return 2;
        }
        return 1;
    }

    private void updateStreak(User user) {
        LocalDate today = LocalDate.now();
        if (user.getLastConnectionDate() != null
                && user.getLastConnectionDate().equals(today.minusDays(1))) {
            user.setStreak(user.getStreak() + 1);
        } else {
            user.setStreak(1);
        }
        user.setLastConnectionDate(today);
    }

    private void badgesCheck(User user) {
        List<Badge> allBadges = badgeRepository.findAll();
        for (Badge badge : allBadges) {
            if (!user.getBadges().contains(badge)
                    && user.getXp() >= badge.getXpCondition()
                    && user.getStreak() >= badge.getStreakCondition()
                    && user.getLevel() >= badge.getLevelCondition()) {
                user.getBadges().add(badge);
            }
        }
    }
}
