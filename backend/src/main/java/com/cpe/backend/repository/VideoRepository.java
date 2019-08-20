package com.cpe.backend.repository;

import com.cpe.backend.model.Video;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface VideoRepository extends JpaRepository<Video, Long> {
    Video findByCode(String code);
}