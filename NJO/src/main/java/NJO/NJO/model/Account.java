package NJO.NJO.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	
	@Id
	@Column(name="USERID")
	private Integer UserID;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="WEIGHT")
	private Integer weight;
	
	@Column(name="FEET")
	private Integer selectFeet;
	
	@Column(name="INCH")
	private Integer selectInch;
	
	@Column(name="EMAIL")
	private String email; 
	
	@Column(name="PASSWORD")
	private String password;
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String fname) {
		this.firstname = fname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lname) {
		this.lastname = lname;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Integer getSelectFeet() {
		return selectFeet;
	}

	public void setSelectFeet(int selectFeet) {
		this.selectFeet = selectFeet;
	}

	public Integer getSelectInch() {
		return selectInch;
	}

	public void setSelectInch(int selectInch) {
		this.selectInch = selectInch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String ename) {
		this.email = ename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return String.format("Name: %s %s email %s Height: %d'%d Weight: %d", this.firstname, this.lastname, this.email, this.selectFeet,this.selectInch, this.weight);
	}

	public Integer getUserID() {
		return UserID;
	}

	public void setUserID(Integer userID) {
		UserID = userID;
	}


}
