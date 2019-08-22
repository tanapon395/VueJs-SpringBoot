package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="RENTAL_TYPE")
public class RentalType {
    @Id
    @SequenceGenerator(name="RENTAL_TYPE_SEQ",sequenceName="RENTAL_TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="RENTAL_TYPE_SEQ")
    @Column(name="RENTAL_TYPE_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy  = "type")
    private Collection<VideoRental> rent;
}