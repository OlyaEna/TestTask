package com.task.task3.service;

import com.task.task3.model.entity.Login;
import com.task.task3.model.repository.LoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class LoginServiceImpl {
//    private final LoginRepository loginRepository;
//
//    public void save(MultipartFile file) {
//        try {
//            List<Login> logins = CSVHelperLogin.csvToLogin(file.getInputStream());
//            loginRepository.saveAll(logins);
//        } catch (IOException e) {
//            throw new RuntimeException("fail to store csv data: " + e.getMessage());
//        }
//    }
//
//    public List<Tutorial> getAllTutorials() {
//        return repository.findAll();
//    }
}
