package com.cpe.backend.repository;

import com.cpe.backend.entity.RentalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface RentalTypeRepository extends JpaRepository<RentalType, Long> {
	RentalType findById(long id);
}