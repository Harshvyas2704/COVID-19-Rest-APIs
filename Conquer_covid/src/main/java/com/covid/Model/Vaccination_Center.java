package com.covid.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.tomcat.util.bcel.Const;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Vaccination_Center {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer code;
	
//	@Pattern(regexp ="^[A-Z][a-z]")
	private String center_Name;

//	@Pattern(regexp ="^[A-Z][a-z]")
	private String address;
	
//	@Pattern(regexp ="^[A-Z][a-z]")
	private String city;
	
//	@Pattern(regexp ="^[A-Z][a-z]")
	private String state;
	
	private Integer slot;
	
	@Size(min =6,max=6,message="Pin Code must be 6 digits")
	private String pinCode;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="vacCenter")
	Set<Appointment> appointment = new HashSet<>();
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	Vaccine vaccine;

	
	
	
}
