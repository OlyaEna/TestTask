package com.task.task3.service.impl;

import com.task.task3.model.entity.Login;
import com.task.task3.model.entity.Posting;
import com.task.task3.model.repository.LoginRepository;
import com.task.task3.model.repository.PostingRepository;
import com.task.task3.service.CSVHelper.CSVHelperPosting;
import com.task.task3.service.PostingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class PostingServiceImpl implements PostingService {
    private final PostingRepository postingRepository;
    private final LoginRepository loginRepository;

    @Override
    public void save(MultipartFile file) {
        try {
            List<Posting> postings = CSVHelperPosting.csvToPosting(file.getInputStream());
            postingRepository.saveAll(postings);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public void saveBooleanIfTrue() {
        List<Login> logins = loginRepository.findAll();
        List<Posting> postings = postingRepository.findAll();
        for (Login login : logins) {
            for (Posting posting : postings) {
                if (login.getAppAccountName().equals(posting.getUserName()) & login.getIsActive().equals(true) ) {
                    posting.setAuthorizedDelivery(true);
                } else {
                    posting.setAuthorizedDelivery(false);
                }
                postingRepository.save(posting);

            }
        }
    }

    @Override
    public List<Posting> getAllTutorials() {
        return postingRepository.findAll();
    }

}
