package com.task.task3.model.repository;

import com.task.task3.dto.DeliveryResponse;
import com.task.task3.model.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {
    @Query("select p from Posting p where date(p.pstngDate) between :from and :to ")
    List<Posting> findByDatePstng(Date from, Date to);

    @Query("select p from Posting p where date(p.docDate) between :from and :to ")
    List<Posting> findByDateDocDate(Date from, Date to);

    @Query("select p from Posting p where date(p.docDate) between :from and :to ")
    List<Posting> findByAuthorizedDelivery(Date from, Date to);
}
