package com.jmolina.spotter.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import com.jmolina.spotter.config.SessionDoa;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository("accountImpl")
public class AccountImpl implements AccountDoa {
	
	@Autowired
	private SessionDoa sessDoa =  (SessionDoa) (new ClassPathXmlApplicationContext("SessionDoaX.xml").getBean("sessionFactory"));  
	private SessionFactory sessFac = sessDoa.sessionFactory();
	private Session sess = sessFac.openSession();
	
	@Override
	public void addAccount(Account acc) {
		checkSessionStatus("open");
		sess.beginTransaction();
		acc.setUserID(genUserID());
		sess.save(acc);
		sess.getTransaction().commit();
		checkSessionStatus("close");
	}
	
	public void checkSessionStatus(String status) {
		if(status.equalsIgnoreCase("close")) {
			if(sess != null) {
				sess.close();
				
			}
		}else if(status.equalsIgnoreCase("open")) {
			if(sess != null) {
				sess.close();
			}
			sess = sessFac.openSession();
		}
	}
	
	@Override
	public void updateAccount(Account acc) {
		checkSessionStatus("open");
		Transaction trax = sess.beginTransaction();
		sess.update(acc);
		trax.commit();
		checkSessionStatus("close");
		
	}
	
	@Override
	public void deleteAccount(Account acc) {
		checkSessionStatus("open");
		sess.beginTransaction();
		Query query = sess.createQuery("delete from Account where userID = :UID");
		query.setParameter("UID",acc.getUserID() );
		query.executeUpdate();
		checkSessionStatus("close");
		
	}
	
	@Override
	public void getLogin(String email) {	
		sess.beginTransaction();
		Query query = sess.createQuery("Select email,password from Account where email = :email");
		query.setParameter("email", email);
		
		System.out.println(query.getFirstResult()+"");
		
		
	}
	
	@Override
	public Object getUserAccount(String email) {
		sess.beginTransaction();
		Query query = sess.createQuery("from Account where email = :email");
		query.setParameter("email", email);
		Account acc = (Account) query.list().get(0);
	
		return acc;
	}
	
	@Override
	public List<Account> getAllUser(){
		this.checkSessionStatus("open");
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Account> query = cb.createQuery(Account.class);
		Root<Account> rootEntry = query.from(Account.class);
		CriteriaQuery<Account> all = query.select(rootEntry);
		
		TypedQuery<Account> allQ = sess.createQuery(all);
		return allQ.getResultList();
	}
	
	public Integer genUserID() {
		String UserID = "";
		for(int i = 0; i < 9; i++) {
			UserID += getInt();
		}
		return  Integer.parseInt(UserID);
	}
	
	public int getInt() {
		return ((int) (Math.random() * 10));
	}
}
