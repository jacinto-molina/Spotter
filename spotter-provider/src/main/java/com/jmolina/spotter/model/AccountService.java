package com.jmolina.spotter.model;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service("accountService")
@Transactional
public class AccountService {
	
	@Autowired
	private AccountImpl accountDbManager;

	//comment for testing in git branches pushes
	
	public void createAccount(Account acc){
		accountDbManager.addAccount(acc);
	}
	
	public void updateAccount(Account acc) {
		accountDbManager.updateAccount(acc);
	}
	
	
	public void deleteAccount(Account acc) {
		accountDbManager.deleteAccount(acc);
	}
	

	public void getLogin(String email) {	
		accountDbManager.getLogin(email);
	}
	  

	public Object getUserAccount(String email) {
		return accountDbManager.getUserAccount(email);
	}
	

	public List<Account> getAllUser(){
		return accountDbManager.getAllUser();
	}
	
	
	
	
}
