package com.task.task3.service.impl;

import com.task.task3.dto.DeliveryResponse;
import com.task.task3.dto.PostingDto;
import com.task.task3.dto.mapper.PostingMapper;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostingServiceImpl implements PostingService {
    private final PostingRepository postingRepository;
    private final LoginRepository loginRepository;
    private final PostingMapper postingMapper;

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
                if (login.getAppAccountName().equals(posting.getUserName()) & login.getIsActive().equals(true)) {
                    posting.setAuthorizedDelivery(true);
                } else {
                    posting.setAuthorizedDelivery(false);
                }
                postingRepository.save(posting);

            }
        }
    }

    private List<DeliveryResponse> convertToResponse(List<Posting> postings) {
        List<DeliveryResponse> responseList = new ArrayList<>();
        for (Posting posting : postings) {
            DeliveryResponse deliveryResponse = new DeliveryResponse();
            deliveryResponse.setUserName(posting.getUserName());
            deliveryResponse.setDocDate(posting.getDocDate());
            deliveryResponse.setAuthorizedDelivery(posting.getAuthorizedDelivery());
            deliveryResponse.setPstngDate(posting.getPstngDate());
            responseList.add(deliveryResponse);
        }
        return responseList;
    }

    public List<DeliveryResponse> findByAuthorizedDelivery(Date from, Date to) {
        List<Posting> postings = postingRepository.findByAuthorizedDelivery(from, to);
        return convertToResponse(postings);
    }

    @Override
    public List<PostingDto> findByDatePstng(Date from, Date to) {
        return postingMapper.listToDto(postingRepository.findByDatePstng(from, to));
    }

    @Override
    public List<PostingDto> findByDateDocDate(Date from, Date to) {
        return postingMapper.listToDto(postingRepository.findByDateDocDate(from, to));
    }

    @Override
    public List<PostingDto> getAllPostings() {
        return postingMapper.listToDto(postingRepository.findAll());
    }

}
