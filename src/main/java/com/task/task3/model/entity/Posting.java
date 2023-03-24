package com.task.task3.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * в файле postings.csv в конце каждой строки была ;
 * я ее удалила
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mat_doc")
    private Long matDoc;
    private Integer item;
    @Column(name = "doc_date")
    private LocalDate docDate;
    @Column(name = "postng_date")
    private LocalDate pstngDate;
    @Column(name = "material_description")
    private String materialDescription;
    private Integer quantity;
    private String bUn;
    private String amountLC;
    private String crcy;
    @Column(name = "user_name")
    private String userName;
//    @Column(name = "authorized_delivery")
//    private Boolean authorizedDelivery;


    public Posting(Long matDoc, Integer item, LocalDate docDate,
                   LocalDate pstngDate, String materialDescription,
                   Integer quantity, String bUn, String amountLC, String crcy, String userName) {
        this.matDoc = matDoc;
        this.item = item;
        this.docDate = docDate;
        this.pstngDate = pstngDate;
        this.materialDescription = materialDescription;
        this.quantity = quantity;
        this.bUn = bUn;
        this.amountLC = amountLC;
        this.crcy = crcy;
        this.userName = userName;
    }
}