package com.task.task3.service;

import org.springframework.web.multipart.MultipartFile;

public interface PostingService {
    void save(MultipartFile file);
}
