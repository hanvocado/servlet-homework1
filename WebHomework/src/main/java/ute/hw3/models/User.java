package ute.hw3.models;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String email;
	private String fullname;
	private String password;
	
	public User(int id, String email, String fullname, String password) {
		super();
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
	}

	public User(String email, String fullname, String password) {
		super();
		this.email = email;
		this.fullname = fullname;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", fullname=" + fullname + ", password=" + password + "]";
	}	
}
