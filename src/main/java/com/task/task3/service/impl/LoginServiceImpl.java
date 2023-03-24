package com.task.task3.service.impl;

import com.task.task3.dto.LoginDto;
import com.task.task3.dto.mapper.LoginMapper;
import com.task.task3.model.entity.Login;
import com.task.task3.model.repository.LoginRepository;
import com.task.task3.service.CSVHelper.CSVHelperLogin;
import com.task.task3.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;

    private final LoginMapper loginMapper;

    @Override
    public void save(MultipartFile file) {
        try {
            List<Login> logins = CSVHelperLogin.csvToLogin(file.getInputStream());
            loginRepository.saveAll(logins);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    @Override
    public List<LoginDto> getAllTutorials() {
        return loginMapper.listToDto(loginRepository.findAll());
    }
}
