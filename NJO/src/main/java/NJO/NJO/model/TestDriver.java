package NJO.NJO.model;

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

import NJO.NJO.config.HibernateUtil;
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
		Database db = new Database();
		
		List<Account> test = (List<Account>)db.getAllUser();
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = mapper.writeValueAsString(test);
			System.out.println(jsonStr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		/*Account acc = (Account)db.getUserAccount("metroidhunter@intergalactic.com");
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String jsonStr = mapper.writeValueAsString(acc);
		
			System.out.println(jsonStr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*
		 * try { String jsonObj = "{\"name\": \"Jacinto\", \"last\":\"Molina\"}";
		 * 
		 * Object obj = new JSONParser().parse(jsonObj); JSONObject json =
		 * (JSONObject)obj; String name = (String) json.get("name"); String last =
		 * (String) json.get("last");
		 * 
		 * System.out.println("name: " + name + "  last:" + last);
		 * 
		 * 
		 * } catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		
		
		
		
		/*acc.setFirstname("Jacinto");
		acc.setLastname("Molina");
		acc.setEmail("jacinto@molina.com");
		acc.setPassword("password");
		acc.setSelectFeet(6);
		acc.setSelectInch(3);
		acc.setWeight(270);
		acc.setUserID(db.genUserID());
		//acc.setPassword("passwords");
		//System.out.println(acc.getUserID());
		//db.addAccount(acc);
		db.addAccount(acc);*/
		
		
		/*Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		Query query = sess.createQuery("delete from Account where UserID = :UID");
		//getter
		//query.setParameter("first", first);
		query.setParameter("UID",acc.getUserID() );
		
		query.executeUpdate();
		
		sess.close();*/
		
		
		
		//System.err.println("Added successfully!!");
		
	}

}
