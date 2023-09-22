package com.thisWebsite.any.servicer;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.thisWebsite.any.entities.registerEntity;
import com.thisWebsite.any.repository.registerRepository;

@Service
public class registrationService {
	
	
	@Autowired
	registerRepository registerRepository;
	
	public String createAccount(registerEntity e) {
		
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder(8, new SecureRandom());
		e.setPassword(bc.encode(e.getPassword()));
		registerRepository.save(e);
		return "success";
	}
}
