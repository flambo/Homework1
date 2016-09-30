package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Customer {
	
	private String id;
	private String password;
	private String name;
	private String gender;
	private String email;
	public Customer(String id, String password, String name, String gender, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.email = email;
	}
	
	

	

}
