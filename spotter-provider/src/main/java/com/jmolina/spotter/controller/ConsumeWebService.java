package com.jmolina.spotter.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jmolina.spotter.model.Account;

@Service("consumeWebService")
public class ConsumeWebService {

	@Autowired
	RestTemplate restTemplate;
	
	//get call
	public String getAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		return restTemplate.exchange("http://localhost:81/Data/GetAllUsers", HttpMethod.GET, entity, String.class).getBody();
	}
	
	//post call
	public ResponseEntity<String> restCreateAccount(Account acc) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Account> entity = new HttpEntity<Account>(acc, headers);
		
		return restTemplate.exchange("http://localhost:81/Data/saveUser", HttpMethod.POST, entity, String.class);
	}
	
	
	//post call
	public ResponseEntity<String> restUpdateAccount(Account acc) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Account> entity = new HttpEntity<Account>(acc, headers);
		
		return restTemplate.exchange("http://localhost:81/Data/updateUser", HttpMethod.POST, entity, String.class);
	}
	
	//post call
	public ResponseEntity<String> restDeleteAccount(Account acc) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Account> entity = new HttpEntity<Account>(acc, headers);
	
		return restTemplate.exchange("http://localhost:81/Data/deleteUser", HttpMethod.POST, entity, String.class);
	}
	
	
}
