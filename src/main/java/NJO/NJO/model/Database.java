package NJO.NJO.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import NJO.NJO.config.HibernateUtil;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Component("database")
public class Database implements DatabaseManager {
	
	@Override
	public void addAccount(Account acc) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		acc.setUserID(genUserID());
		sess.save(acc);
		sess.getTransaction().commit();
	}
	
	@Override
	public void updateAccount(Account acc) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transaction trax = sess.beginTransaction();
		sess.update(acc);
		trax.commit();
		sess.close();
	}
	
	@Override
	public void deleteAccount(Account acc) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		Query query = sess.createQuery("delete from Account where UserID = :UID");
		//getter
		query.setParameter("UID",acc.getUserID() );
		query.executeUpdate();
		sess.close();
	}
	
	@Override
	public void getLogin(String email) {	
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		Query query = sess.createQuery("Select email,password from Account where email = :email");
		//getter
		//query.setParameter("first", first);
		query.setParameter("email", email);
		
		System.out.println(query.getFirstResult()+"");
		sess.close();
		
	}
	
	@Override
	public Object getUserAccount(String email) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		Query query = sess.createQuery("from Account where email = :email");
		//getter
		//query.setParameter("first", first);
		query.setParameter("email", email);
		
		Account acc = (Account) query.list().get(0);
		sess.close();
		return acc;
	}
	
	@Override
	public List<Account> getAllUser(){
		Session sess = HibernateUtil.getSessionFactory().openSession();
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
