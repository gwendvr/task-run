package com.task.task_run.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.task.task_run.model.Badge;
import com.task.task_run.model.Priorite;
import com.task.task_run.model.Task;
import com.task.task_run.model.User;
import com.task.task_run.repository.BadgeRepository;
import com.task.task_run.repository.TaskRepository;
import com.task.task_run.repository.UserRepository;

@Service
public class InitService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final BadgeRepository badgeRepository;

    public InitService(UserRepository userRepository, TaskRepository taskRepository, BadgeRepository badgeRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.badgeRepository = badgeRepository;
    }

    public void initClientIfNeeded(String clientId) {
        if (userRepository.findByClientId(clientId).isPresent()) return;

        // Créer les 2 badges de départ s'ils n'existent pas encore
        Badge badge1 = badgeRepository.findByNom("Bienvenue")
            .orElseGet(() -> {
                Badge b = new Badge();
                b.setNom("Bienvenue");
                b.setDescription("Tu as rejoint Task Run !");
                b.setIcone("🎉");
                b.setXpCondition(0);
                b.setStreakCondition(0);
                b.setLevelCondition(0);
                return badgeRepository.save(b);
            });

        Badge badge2 = badgeRepository.findByNom("Première tâche")
            .orElseGet(() -> {
                Badge b = new Badge();
                b.setNom("Première tâche");
                b.setDescription("Tu as créé ta première tâche !");
                b.setIcone("✅");
                b.setXpCondition(0);
                b.setStreakCondition(0);
                b.setLevelCondition(0);
                return badgeRepository.save(b);
            });

        Badge badge3 = badgeRepository.findByNom("5 jours de suite")
            .orElseGet(() -> {
                Badge b = new Badge();
                b.setNom("5 jours de suite");
                b.setDescription("Tu as complété 5 jours de suite !");
                b.setIcone("5️⃣");
                b.setXpCondition(0);
                b.setStreakCondition(5);
                b.setLevelCondition(0);
                return badgeRepository.save(b);
            });

        // Set default user data
        User user = new User();
        user.setNom("Aventurier");
        user.setXp(0);
        user.setLevel(1);
        user.setStreak(0);
        user.setClientId(clientId);
        user.setBadges(List.of(badge1, badge2));
        userRepository.save(user);

        // set default task
        Task task = new Task();
        task.setTitle("Bienvenue sur Task Run ! 🎉");
        task.setDescription("Complète cette tâche pour gagner tes premiers XP !");
        task.setPriorite(Priorite.MOYENNE);
        task.setClientId(clientId);
        taskRepository.save(task);
    }
}