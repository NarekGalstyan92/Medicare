package com.medicare.medicare.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String working_days;
    private String email;
    private String fax;
    private String openTime;
    private String closeTime;
    private String address;
    private String information;
    private String contactPhone;
    @ManyToOne
    private MedService medService;

}
