package com.thisWebsite.any.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thisWebsite.any.entities.registerEntity;
import com.thisWebsite.any.servicer.registrationService;

@RestController
public class controller {
	
	@Autowired
	registrationService registrationService;
	
	@GetMapping("newAccount")
	public String createNewAccount(@RequestBody registerEntity account) {
		return registrationService.createAccount(account);
	}
	
}
