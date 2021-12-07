package com.jmolina.spotter.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SessionDoa {//SessionDoa
	
	@Bean
	public SessionFactory sessionFactory() {
		 SessionFactory sessionHib = new Configuration().configure().buildSessionFactory();
		 return sessionHib;
	}
	
	
}
