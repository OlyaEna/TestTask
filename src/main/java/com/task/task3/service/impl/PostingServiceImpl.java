package com.task.task3.service.impl;

import com.task.task3.model.entity.Login;
import com.task.task3.model.entity.Posting;
import com.task.task3.model.repository.PostingRepository;
import com.task.task3.service.CSVHelper.CSVHelperLogin;
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

    @Override
    public void save(MultipartFile file) {
        try {
            List<Posting> postings = CSVHelperPosting.csvToPosting(file.getInputStream());
            postingRepository.saveAll(postings);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
