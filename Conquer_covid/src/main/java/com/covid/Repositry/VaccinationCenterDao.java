package com.covid.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.Model.Vaccination_Center;
@Repository
public interface VaccinationCenterDao extends JpaRepository<Vaccination_Center, Integer>{

	
	public Vaccination_Center findByPinCode(String pinCode);
}
