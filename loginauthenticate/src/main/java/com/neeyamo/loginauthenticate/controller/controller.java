package com.neeyamo.loginauthenticate.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neeyamo.loginauthenticate.entity.entityClass;
import com.neeyamo.loginauthenticate.entity.loginEntity;
import com.neeyamo.loginauthenticate.service.servicer;

@RestController
@CrossOrigin("http://localhost:4200")
public class controller {
	
	@Autowired
	servicer e;
	
	
	@PostMapping("newEmp")
	public String create(@RequestBody entityClass abc) throws NoSuchAlgorithmException {
		return e.newEmployee(abc);
	}
	
	
	@PostMapping("login")
	public String validate(@RequestBody loginEntity abc) throws NoSuchAlgorithmException {
		return e.loginValidate(abc);
	}
	
	@GetMapping("/getall")
	public List<entityClass> allOfEm() {
		return e.giveCacheAll();
	}
	
	@GetMapping("/getallcache")
	public List<entityClass> allOfIt() {
		return e.giveAll();
	}
	
	@GetMapping("update")
	public List<entityClass> giveupdated() {
		return e.updater();
	}
}
