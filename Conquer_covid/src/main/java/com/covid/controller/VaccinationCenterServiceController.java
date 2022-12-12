package com.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.validation.Valid;

import com.covid.Exception.Vaccination_Center_Exception;
import com.covid.Model.Vaccination_Center;
import com.covid.Service.VaccinationCenterServiceImpl;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationCenterServiceController {
	
	@Autowired
	private VaccinationCenterServiceImpl vService;
	
	
	@GetMapping("/allCenter")
	public ResponseEntity<List<Vaccination_Center>> allVaccineCenterHandler() throws Vaccination_Center_Exception{
		
		List<Vaccination_Center> vList = vService.allVaccineCenter();
		
		return new ResponseEntity<List<Vaccination_Center>>(vList, HttpStatus.OK);
	}
	
	
	@GetMapping("/getCenter/{cid}")
	public ResponseEntity<Vaccination_Center> getVaccineCenterHandler(@PathVariable("cid") Integer centerId) throws Vaccination_Center_Exception{
		
		
		return new ResponseEntity<Vaccination_Center>(vService.getVaccineCenter(centerId),HttpStatus.OK);
		
	}
	
	
	@PostMapping("/addCenter/{Vid}")
	public ResponseEntity<Vaccination_Center> addVaccineCenterHandler(@Valid @RequestBody Vaccination_Center vCenter,@PathVariable("Vid")Integer Vid) throws Vaccination_Center_Exception{
		
		Vaccination_Center vc = vService.addVaccineCenter(vCenter,Vid);
		
		return new ResponseEntity<Vaccination_Center>(vc, HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/updateCenter")
	public ResponseEntity<Vaccination_Center> updateVaccineCenterHandler(@Valid @RequestBody Vaccination_Center vc) throws Vaccination_Center_Exception{
		
		Vaccination_Center center = vService.updateVaccineCenter(vc);
		
		return new ResponseEntity<Vaccination_Center>(center, HttpStatus.CREATED);
		
	}

}
