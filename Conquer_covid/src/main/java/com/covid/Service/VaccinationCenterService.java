package com.covid.Service;

import java.util.List;

import com.covid.Exception.Vaccination_Center_Exception;
import com.covid.Model.Member;
import com.covid.Model.Vaccination_Center;

public interface VaccinationCenterService {
	
	public List<Vaccination_Center> allVaccineCenter() throws Vaccination_Center_Exception;
	
	public Vaccination_Center getVaccineCenter(Integer centerid) throws Vaccination_Center_Exception;
	
	public Vaccination_Center addVaccineCenter(Vaccination_Center center, Integer Vid) throws Vaccination_Center_Exception;
	
	
	public Vaccination_Center updateVaccineCenter(Vaccination_Center center) throws Vaccination_Center_Exception;

	public boolean deleteCenter(Vaccination_Center center) throws Vaccination_Center_Exception;

	
}
