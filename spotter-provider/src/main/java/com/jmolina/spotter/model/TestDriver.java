package com.jmolina.spotter.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmolina.spotter.config.SessionDoa;

import jakarta.persistence.Column;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


public class TestDriver {

	private String firstname;
	private String lastname;
	private Integer weight;
	private Integer selectFeet;
	private Integer selectInch;
	private String email;
	private String password;

	public static void main(String[] args) {
		
	}

}
