package com.sos.example.salesorderservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class CustomerSos {

	@Id
	@Column(name="cust_id")
	private Long custId;
	
	@Column(name="cust_first_name")
	@JsonProperty("firstName")
	private String custFirstName;
	
	@Column(name="cust_last_name")
	@JsonProperty("lastName")
	private String custLastName;
	
	@Column(name="cust_email")
	@JsonProperty("email")
	private String custEmail;

	
	public CustomerSos() {
		super();
	}

	public CustomerSos(Long custId, String custFirstName, String custLastName, String custEmail) {
		super();
		this.custId = custId;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custEmail = custEmail;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	
}
