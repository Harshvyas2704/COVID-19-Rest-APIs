package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.Exception.MemberException;
import com.covid.Exception.VaccineRegistration_Excepton;
import com.covid.Model.VaccineRegistration;
import com.covid.Service.VaccineRegistrationServiceImpl;

@RestController
@RequestMapping("/vaccineRegistration")
public class VacccineRegistrationController {
	
	@Autowired
	VaccineRegistrationServiceImpl vrService;
	
	@GetMapping("/{id}")
	public ResponseEntity<VaccineRegistration> getVaccineRegistration(@PathVariable("id")String mobileno)throws VaccineRegistration_Excepton{
		VaccineRegistration vr = vrService.getVaccineRegistration(mobileno);
		return new ResponseEntity<>(vr,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<VaccineRegistration>> getallMember() throws MemberException{
		List<VaccineRegistration> list = vrService.getallMember();
		 return new ResponseEntity<>(list,HttpStatus.OK);

	}
	
	@PostMapping("/add")
	public ResponseEntity<VaccineRegistration> addVaccineRegistration(@RequestBody VaccineRegistration reg )throws VaccineRegistration_Excepton{
		VaccineRegistration vr =  vrService.addVaccineRegistration(reg);
		return new ResponseEntity<>(vr,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<VaccineRegistration> updatemember(@RequestBody VaccineRegistration reg)throws VaccineRegistration_Excepton{
		VaccineRegistration vr = vrService.updatemember(reg);
		return new ResponseEntity<>(vr,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deletemember(@PathVariable("id") String id)throws VaccineRegistration_Excepton{
		return new ResponseEntity<>(vrService.deletemember(id),HttpStatus.OK);
	}

	
}
