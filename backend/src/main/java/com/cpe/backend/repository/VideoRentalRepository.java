package com.cpe.backend.repository;

import com.cpe.backend.entity.VideoRental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface VideoRentalRepository extends JpaRepository<VideoRental, Long> {
}