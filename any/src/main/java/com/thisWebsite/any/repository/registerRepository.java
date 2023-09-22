package com.thisWebsite.any.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thisWebsite.any.entities.registerEntity;


@Repository
public interface registerRepository extends JpaRepository<registerEntity, String>{

}
