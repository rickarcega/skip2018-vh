package br.skip.code.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerBO {

	/*
	 * "id": 1223344, "email": "ricardo@arcega.com", "name": "Ricardo Arcega",
	 * "address": "R Test ", "creation": "2018-03-17T15:35:09.589Z", "password":
	 * "arcega"
	 */

	private int id;
	private String email;
	private String adress;
	private Date creation;
	private String password;

	public CustomerBO() {

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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {

		return "{" + "id: 1223344, " + "email: 'ricardo@arcega.com'," + "name: 'Ricardo Arcega'," + "address: 'R Test',"
				+ "creation: '2018-03-17T15:35:09.589Z'," + "password: 'arcega' }";
	}
}
