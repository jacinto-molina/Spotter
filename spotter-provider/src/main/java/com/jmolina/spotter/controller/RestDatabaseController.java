package com.jmolina.spotter.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmolina.spotter.model.Account;
import com.jmolina.spotter.model.AccountService;

@RestController
public class RestDatabaseController {

	//Interacts with the database and send data to the ConsumeWebService..
	
	@Autowired
	private AccountService accService;
	
	//this one returns the database stuff... 
	@CrossOrigin(origins = "http://localhost:81")
	@RequestMapping(value="/Data/GetAllUsers", method = RequestMethod.GET)
	public ResponseEntity<Object> GetAllUsers() throws JsonProcessingException{
			List<Account> test = (List<Account>)accService.getAllUser();
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = mapper.writeValueAsString(test);
		
		return new ResponseEntity<Object>(jsonStr,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:81")
	@RequestMapping(value="/Data/saveUser", method = RequestMethod.POST)
	public ResponseEntity<Object> restCreateAccount(@RequestBody Account acc) {
		accService.createAccount(acc);
		
		return new ResponseEntity<Object>("",HttpStatus.CREATED); 
	}
	
	
	@CrossOrigin(origins = "http://localhost:81")
	@RequestMapping(value="/Data/updateUser", method = RequestMethod.POST)
	public ResponseEntity<Object> restUpdateAccount(@RequestBody Account acc) {
		accService.updateAccount(acc);
		return new ResponseEntity<Object>("",HttpStatus.OK);
	}
		
		@CrossOrigin(origins = "http://localhost:81")
		@RequestMapping(value="/Data/deleteUser", method = RequestMethod.POST)
		public ResponseEntity<Object> restDeleteAccount(@RequestBody Account acc) {
			accService.deleteAccount(acc);
			return new ResponseEntity<Object>("", HttpStatus.OK);
	}
		
		
	
}
