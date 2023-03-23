package com.task.task3.service;

import com.task.task3.model.entity.Login;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LoginService {

    void save(MultipartFile file);
    List<Login> getAllTutorials();
}
