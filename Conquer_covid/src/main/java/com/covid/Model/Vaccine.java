package com.covid.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class Vaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineId;

	private String vaccninName;

	private String description;
	private Integer quantity;

	private Double price;

	@FutureOrPresent
	private Date localDate;
	
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="vaccine")
	Set<Member> member = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="vaccine")
	Set<Vaccination_Center> centers = new HashSet<>();
	
	
}
