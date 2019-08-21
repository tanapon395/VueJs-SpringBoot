package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.cpe.backend.entity.Employee;;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="VIDEO_RENTAL")
public class VideoRental {

    @Id
    @SequenceGenerator(name="video_rental_seq",sequenceName="video_rental_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="video_rental_seq")
    @Column(name = "VIDEO_RENTAL_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @Column(name="RENT_DATE")
    private @NonNull Date rentDate;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", insertable = true)
    private Employee createdBy;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Video.class)
    @JoinColumn(name = "VIDEO_ID", insertable = true)
    private Video video;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID", insertable = true)
    private Customer rentCustomer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RentalType.class)
    @JoinColumn(name = "RENTAL_TYPE_ID", insertable = true)
    private RentalType type;
}