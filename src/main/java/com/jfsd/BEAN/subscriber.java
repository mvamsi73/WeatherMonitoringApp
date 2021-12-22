package com.jfsd.BEAN;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class subscriber 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subscriberID;
	String email;
	long phone_number;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

}
