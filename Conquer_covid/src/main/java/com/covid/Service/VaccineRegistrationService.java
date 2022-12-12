package com.covid.Service;

import java.util.List;


import com.covid.Exception.MemberException;

import com.covid.Exception.VaccineRegistration_Excepton;
import com.covid.Model.VaccineRegistration;

import com.covid.Model.Member;

public interface VaccineRegistrationService {
	
  
	
	public VaccineRegistration getVaccineRegistration(String mobileno)throws VaccineRegistration_Excepton;
	
	public List<VaccineRegistration> getallMember() throws MemberException;
	
	public VaccineRegistration addVaccineRegistration(VaccineRegistration reg )throws VaccineRegistration_Excepton;
	
	public VaccineRegistration updatemember(VaccineRegistration reg)throws VaccineRegistration_Excepton;
	
	public boolean deletemember(String id)throws VaccineRegistration_Excepton;

	



	

}
