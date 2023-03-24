package com.task.task3.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryResponse {
    private String userName;
    private Boolean authorizedDelivery;
    private LocalDate docDate;
    private LocalDate pstngDate;
}
