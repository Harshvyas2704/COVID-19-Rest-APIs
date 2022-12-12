package com.covid.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@AssertFalse
	private Boolean dose1_Status;
	@AssertFalse
	private Boolean dose2_Status;
//	@FutureOrPresent
	private Date does1_Date;
//@FutureOrPresent
	private Date does2_Date;
	
	@Size(min=3,max=20,message="Name length should be between 3-20")
	private String name;
	
	@FutureOrPresent
	private Date localDate;

	private String gender;

	private String address;

	private String city;

	@Size(min=6,max=6,message="Pincode must be 6 digits")
	private String pinCode;

	@Size(min=10,max=10,message="Pan Number must be 10 digits")
	private String panNo;

	@Size(min=12,max=12,message="Aadhaar Number must be 12 digits")
	private String adharNo;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	VaccineRegistration vaccineRegisteration;
	
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	Vaccine vaccine;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	Appointment appointment;

	 
	
	
}
