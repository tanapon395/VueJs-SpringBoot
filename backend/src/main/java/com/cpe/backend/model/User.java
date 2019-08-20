package com.cpe.backend.model;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="user")
public class User {
	@Id
	@SequenceGenerator(name="user_seq",sequenceName="user_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")      
	@Column(name="USER_ID",unique = true, nullable = true)
	private @NonNull Long id;
	private @NonNull String username;

}
