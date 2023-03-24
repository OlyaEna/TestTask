package com.task.task3.service;

import com.task.task3.model.entity.Posting;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostingService {
    void save(MultipartFile file);
    public void saveBooleanIfTrue();
    List<Posting> getAllTutorials();
}
