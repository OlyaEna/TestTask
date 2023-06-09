package com.task.task3.service;

import com.task.task3.dto.DeliveryResponse;
import com.task.task3.dto.PostingDto;
import com.task.task3.model.entity.Posting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

public interface PostingService {
    void save(MultipartFile file);

    public void saveBooleanIfTrue();

    List<PostingDto> getAllPostings();

    List<DeliveryResponse> findByAuthorizedDelivery(Date from, Date to);

    List<PostingDto> findByDatePstng(Date from, Date to);

    List<PostingDto> findByDateDocDate(Date from, Date to);

}

