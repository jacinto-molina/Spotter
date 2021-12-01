package NJO.NJO.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import NJO.NJO.config.HibernateUtil;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public interface DatabaseManager {
	public void addAccount(Account acc);
	public void updateAccount(Account acc);
	public void deleteAccount(Account acc);
	public void getLogin(String email);
	public Object getUserAccount(String email);
	public List<Account> getAllUser();
	
}
