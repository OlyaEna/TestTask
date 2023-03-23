package com.task.task3.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Posting{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mat_doc")
    private Long matDoc;
    private Integer item;

    @Column(name = "doc_date")
    private LocalDateTime docDate;

    @Column(name = "postng_date")
    private LocalDateTime pstngDate;

    @Column(name = "material_description")
    private String materialDescription;
    private Integer quantity;
    private String bUn;
    private Double amountLC;
    private String crcy;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "authorized_delivery")
    private Boolean authorizedDelivery;
}