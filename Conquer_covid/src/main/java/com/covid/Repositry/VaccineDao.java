package com.covid.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.Model.Vaccine;
@Repository
public interface VaccineDao extends JpaRepository<Vaccine, Integer> {


	List<Vaccine> findByVaccninName(String vaccninName);

	

}
