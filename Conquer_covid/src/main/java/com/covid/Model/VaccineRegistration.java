package com.covid.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor


@Entity
public class VaccineRegistration {
	@Id
	@Size(min=10,max=10,message="Mobile number must be 10 digits")
	private String mobileNo;

	@Size(min=8,max=15,message="Password must be 8-15 digits")
	private String password;

	@FutureOrPresent
	private Date dateOfRegistration;
	
	@OneToOne(cascade = CascadeType.ALL)
	Member member;

	
	
}
