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
import com.jmolina.spotter.model.Account;
import com.jmolina.spotter.model.AccountService;
import com.jmolina.spotter.model.AccountImpl;


@Controller
public class HomeController {
		
	@Autowired
	private AccountService accService;
	
	@Autowired
	private ConsumeWebService restConsume;

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
	
	@RequestMapping(value="/createAcc",method= RequestMethod.POST) //spring bean object copy, 
	public ModelAndView createAcc(Account account) {
	
		ModelAndView confirmAccPage = new ModelAndView("/");
		
		confirmAccPage.addObject("acc",account); //use Account object being passed in.
		return confirmAccPage;
	}
	
	@RequestMapping(value="/managerView", method=RequestMethod.GET)
	public ModelAndView managerView(HttpServletResponse response) {
		return new ModelAndView("manager");
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value="/serverTest", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> serverTest() {
		//logger.info("In testing Server! from frontend...");
		System.out.println("In Spring Getter EndPoint... ");
		HashMap <String, String> map = new HashMap<>();
		map.put("Firstname", "Larry");
		map.put("Lastname", "Scary");
		map.put("Email", "Terror@gmail.com");
		map.put("SelectFeet", "6");
		map.put("SelectInch", "4");
		map.put("Weight", "290");
		return new ResponseEntity<Object>( map,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:81")
	@RequestMapping(value="/getUser", method= RequestMethod.POST)
	public ResponseEntity<Object> getUser(@RequestBody String userEmail) throws JsonMappingException, JsonProcessingException, ParseException{
		ObjectMapper objMap = new ObjectMapper();
		
		Object obj = new JSONParser().parse(userEmail);
		JSONObject json = (JSONObject)obj;
		String email = (String) json.get("email");
		
		System.out.println("email: " + email);
		Account acc = (Account)accService.getUserAccount(email);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(acc);
	
		return new ResponseEntity<Object>(jsonStr,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:81")
	@RequestMapping(value="/GetAllUsers", method = RequestMethod.GET)
	public ResponseEntity<Object> GetAllUsers() throws JsonProcessingException{
			List<Account> test = (List<Account>)accService.getAllUser();
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = mapper.writeValueAsString(test);
		
		return new ResponseEntity<Object>(jsonStr,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value="/GetAllUsersTest", method = RequestMethod.GET)
	public ResponseEntity<Object> GetAllUsersTest() throws JsonProcessingException{
		System.out.println("In testing method for rest Template");	
		ObjectMapper objmap = new ObjectMapper();
			Account[] list = objmap.readValue(restConsume.getAllUsers(), Account[].class);
			
			List<Account> test = Arrays.asList(list);
			
			//List<Account> test = (List<Account>)accService.getAllUser();
			//ObjectMapper mapper = new ObjectMapper();
			String jsonStr = objmap.writeValueAsString(test);
		
		return new ResponseEntity<Object>(jsonStr,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value="/saveUser", method = RequestMethod.POST)
	public ResponseEntity<Object> saveUser(@RequestBody String obj) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objMap = new ObjectMapper();
		Account acc = objMap.readValue(obj, Account.class);
		HttpStatus status = restConsume.restCreateAccount(acc).getStatusCode();
		return new ResponseEntity<Object>("",status);
	}
	
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value="/deleteUser", method = RequestMethod.POST)
	public ResponseEntity<Object> deleteUser(@RequestBody String obj) throws JsonMappingException, JsonProcessingException{
		ObjectMapper objMap = new ObjectMapper();
		Account acc = objMap.readValue(obj, Account.class);
		
		HttpStatus status = restConsume.restDeleteAccount(acc).getStatusCode();
		
		return new ResponseEntity<Object>("",status);
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value="/updateUser", method = RequestMethod.POST)
	public ResponseEntity<Object> updateUser(@RequestBody String obj) throws JsonMappingException, JsonProcessingException{
		ObjectMapper objMap = new ObjectMapper();
		Account acc = objMap.readValue(obj, Account.class);
		
		HttpStatus status = restConsume.restUpdateAccount(acc).getStatusCode();
		return new ResponseEntity<Object>("",status);
	}
	
	
}
