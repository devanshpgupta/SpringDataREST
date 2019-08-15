package com.springdatarest.eventmanagement.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Venue extends AbstractEntity {

	@Column(name ="name")
	private String name;
	
	@Column(name = "STREET_ADDRESS")
	private String streetaddress;
	
	@Column(name ="STREET_ADDRESS2")
	private String streetaddress2;
	
	@Column(name ="city")
	private String city;
	
	@Column(name ="state")
	private String state;
	
	@Column(name ="country")
	private String country;
	
	@Column(name ="POSTAL_CODE")
	private String postalcode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetaddress() {
		return streetaddress;
	}

	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}

	public String getStreetaddress2() {
		return streetaddress2;
	}

	public void setStreetaddress2(String streetaddress2) {
		this.streetaddress2 = streetaddress2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Venue) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
