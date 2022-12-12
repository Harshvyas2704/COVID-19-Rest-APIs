package com.covid.Service;

import java.util.List;

import com.covid.Exception.Vaccine_Exception;
import com.covid.Model.Vaccine;

public interface VaccineService {


	public Vaccine getVaccineByName(String VaccninName) throws Vaccine_Exception;

	public Vaccine getVaccineById(Integer vaccineId) throws Vaccine_Exception;

	public Vaccine addVaccine(Vaccine vaccine) throws Vaccine_Exception;

	public Vaccine updateVaccine(Vaccine vaccine) throws Vaccine_Exception;

	public Boolean deleteVaccine(Integer vid) throws Vaccine_Exception;


	

	
}
