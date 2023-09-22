package com.neeyamo.loginauthenticate.repository;

import java.util.List;

import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.JpaRepository;

import com.neeyamo.loginauthenticate.entity.entityClass;

public interface empRepository extends JpaRepository<entityClass, String>{
	
	
	

	@Override
	@CachePut(value = "allemp")
	List<entityClass> findAll();
}
