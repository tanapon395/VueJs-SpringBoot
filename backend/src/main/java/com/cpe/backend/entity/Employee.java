package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
@Table(name="EMPLOYEE")
public class Employee {
    @Id
    @SequenceGenerator(name="EMPLOYEE_SEQ",sequenceName="EMPLOYEE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EMPLOYEE_SEQ")
    @Column(name="EMPLOYEE_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String name;

    @OneToMany(fetch = FetchType.EAGER)
    // mappedBy  = "createdBy"
    private Collection<VideoRental> rent;
}