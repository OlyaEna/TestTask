package com.task.task3.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostingDto {
    private Long id;
    private Long matDoc;
    private Integer item;
    private LocalDate docDate;
    private LocalDate pstngDate;
    private String materialDescription;
    private Integer quantity;
    private String bUn;
    private String amountLC;
    private String crcy;
    private String userName;
    private Boolean authorizedDelivery;
}
