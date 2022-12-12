package com.covid.controller;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.Exception.Vaccine_Exception;
import com.covid.Model.Vaccination_Center;
import com.covid.Model.Vaccine;
import com.covid.Service.VaccineServiceImpl;

@RestController
@RequestMapping("/vaccine")
public class VaccineServiceController {
	
	@Autowired
	private VaccineServiceImpl vService;
	
	
	@GetMapping("/vaccineName/{name}")
	public ResponseEntity<Vaccine> getVaccineByNameHandler(@Valid @PathVariable("name") String vaccineName) throws Vaccine_Exception{
		
		Vaccine vac = vService.getVaccineByName(vaccineName);
		
		return new ResponseEntity<Vaccine>(vac, HttpStatus.OK);
		
	}
	
	@GetMapping("/vaccineId/{id}")
	public ResponseEntity<Vaccine> getVaccineByIdHandler(@PathVariable("id") Integer id) throws Vaccine_Exception{
		
		Vaccine vac = vService.getVaccineById(id);
		
		return new ResponseEntity<Vaccine>(vac, HttpStatus.OK);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Vaccine> addVaccineHandler(@Valid@RequestBody Vaccine vacc) throws Vaccine_Exception
	{
		Vaccine vac =vService.addVaccine(vacc);
		
		return new ResponseEntity<Vaccine>(vac,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("{put}")
	public ResponseEntity<Vaccine> updateVaccineHandler(@Valid @RequestBody Vaccine vaccine ) throws Vaccine_Exception
	{
	 Vaccine vac=vService.updateVaccine(vaccine);
	 
	 return new ResponseEntity<Vaccine>(vac,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{vaccineId}")
	public ResponseEntity<Boolean> deleteVaccineHandler(@Valid @PathVariable("vaccineId")Integer vid) throws Vaccine_Exception
	{
		boolean res = vService.deleteVaccine(vid);
		
		return new ResponseEntity<Boolean>(res,HttpStatus.OK);
	}

}
