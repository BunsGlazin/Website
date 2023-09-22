package com.neeyamo.loginauthenticate.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.neeyamo.loginauthenticate.entity.entityClass;
import com.neeyamo.loginauthenticate.entity.loginEntity;
import com.neeyamo.loginauthenticate.repository.empRepository;

@Service
public class servicer {
	@Autowired
	empRepository empe;
	
	
	@SuppressWarnings("unused")
	private CacheManager cacheManager;
	
	
	public List<entityClass> giveCacheAll() {
		System.out.println("call made");
		return empe.findAll();
	}
	
	
	@Cacheable(value = "allemp")
	public List<entityClass> updater() {
		return null;
	}
	
	
	public List<entityClass> giveAll() {
		System.out.println("cache taken");
		//@SuppressWarnings("unchecked")
		//List<entityClass> allemp = (List<entityClass>) this.cacheManager.getCache("allemp");
		return null;
	}
	
	//@CachePut
	public String newEmployee(entityClass abc) throws NoSuchAlgorithmException {
		abc.setEmpId("ET" + ((empe.findAll().size() + 1)>9 ? (empe.findAll().size() + 1) : "0" + (empe.findAll().size() + 1)));
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		byte[] hash = md.digest(abc.getPassword().getBytes(StandardCharsets.UTF_8));
		BigInteger number = new BigInteger(1, hash);
		StringBuilder hexString = new StringBuilder(number.toString(16));
		while (hexString.length() < 32) {
			hexString.insert(0, '0');
		}
		abc.setPassword(hexString.toString());
		
		empe.save(abc);
		empe.findAll();
		//empe.findAll();
		return abc.getEmpId();
	}

	public String loginValidate(loginEntity input) throws NoSuchAlgorithmException {
		
		Optional<entityClass> finder1 = empe.findById(input.empId);
		if(finder1.orElse(null)==null) {
			return "Invalid empId";
		}
		else {
			@SuppressWarnings("deprecation")
			entityClass finder = empe.getById(input.empId);
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] hash = md.digest(input.password.getBytes(StandardCharsets.UTF_8));
			BigInteger number = new BigInteger(1, hash);
			StringBuilder hexString = new StringBuilder(number.toString(16));
			while (hexString.length() < 32)  
			{  
				hexString.insert(0, '0');  
			}
			if(hexString.toString().equals(finder.getPassword())) {
				return "success "+finder.getEmpName();
			}
			else {
				return "incorrect Password";
			}
		}
		
	}

}
