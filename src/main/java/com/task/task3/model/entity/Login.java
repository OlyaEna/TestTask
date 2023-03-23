package com.task.task3.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "logins")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String application;
    @Column(name = "app_account_name")
    private String appAccountName;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "job_title")
    private String jobTitle;
    private String department;

    public Login(String application, String appAccountName, Boolean isActive, String jobTitle, String department) {
        this.application = application;
        this.appAccountName = appAccountName;
        this.isActive = isActive;
        this.jobTitle = jobTitle;
        this.department = department;
    }
}