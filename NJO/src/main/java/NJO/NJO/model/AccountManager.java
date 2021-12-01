package NJO.NJO.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

//manager
//Missing tag for autowired 
@Component("accManager")
public class AccountManager {
	@Autowired
	private Database database;
	
	public AccountManager(){
		this.database = new Database();
		
	}
	
	@Async
	public void addAccount(Account acc) {
		database.addAccount(acc);
	}
	
	
}
