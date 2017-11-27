package sampleApp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="users")
public class Users implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	private String firstname;
	private String lastname;
	private String gender;
	private String username;
	private String password;
	
public Users() {
		
	}
	
	public Users(String firstname, String lastname, String gender, String username, String password) {		
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", username=" + username + ", password=" + password + "]";
	}
	
	
	

}
