package com.task.task3.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private Long id;
    private String application;
    private String appAccountName;
    private Boolean isActive;
    private String jobTitle;
    private String department;
}
