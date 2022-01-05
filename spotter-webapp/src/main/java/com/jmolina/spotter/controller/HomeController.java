package com.jmolina.spotter.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
public class HomeController {

	@RequestMapping(value="/",method= RequestMethod.GET)
	public ModelAndView test(HttpServletResponse response){
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/about",method= RequestMethod.GET)
	public ModelAndView about(HttpServletResponse response){
		return new ModelAndView("about");
	}
	
	@RequestMapping(value="/login",method= RequestMethod.GET)
	public ModelAndView login(HttpServletResponse response){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/profile",method= RequestMethod.GET)
	public ModelAndView profile(HttpServletResponse response){
		return new ModelAndView("profile");
	}
	@RequestMapping(value="/setting",method= RequestMethod.GET) //Get or Post
	public ModelAndView setting(HttpServletResponse response){
		return new ModelAndView("setting");
	}
	@RequestMapping(value="/workouts",method= RequestMethod.GET)
	public ModelAndView workouts(HttpServletResponse response){ //slf4J -implementing log4j
		
		return new ModelAndView("workouts");
	}
	@RequestMapping(value="/createAccount",method= RequestMethod.GET)
	public ModelAndView createAccount(HttpServletResponse response){
		return new ModelAndView("createUserAccount");
	}
	

	@RequestMapping(value="/managerView", method=RequestMethod.GET)
	public ModelAndView managerView(HttpServletResponse response) {
		return new ModelAndView("manager");
	}
	
}
