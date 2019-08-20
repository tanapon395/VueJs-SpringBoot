package com.cpe.backend.repository;

import com.cpe.backend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}