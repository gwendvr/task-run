package com.task.task_run.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.task.task_run.model.Tag;
import com.task.task_run.repository.TagRepository;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> recoverAll() {
        return tagRepository.findAll();
    }

    public Tag create(Tag tag) {
        return tagRepository.save(tag);
    }

    public void delete(Long id) {
        tagRepository.deleteById(id);
    }
}