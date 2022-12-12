package com.covid.Model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	
	private String mobile_No;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM/dd/yyyy")
	private Date date_Of_Booking;

	@JsonIgnore
	private Boolean booking_Status;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	Member member;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Vaccination_Center vacCenter;
	
	
	
	
	
	
	
}
