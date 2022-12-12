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
import org.springframework.web.bind.annotation.RestController;

import com.covid.Exception.AppointmentException;
import com.covid.Exception.MemberException;
import com.covid.Model.Appointment;
import com.covid.Model.Member;
import com.covid.Service.AppointmentServiceImpl;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentServiceImpl appService;
	
	@GetMapping("/appointment/{id}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable("id") Long id) throws AppointmentException{
		Appointment app = appService.getAppointment(id);
		
		return new ResponseEntity<>(app,HttpStatus.OK);
	}
	
	@PostMapping("/appointment")
	public ResponseEntity<Appointment> addAppointment(@Valid @RequestBody Appointment app)throws AppointmentException{
		Appointment app1 = appService.addAppointment(app);
		return new ResponseEntity<>(app1,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/appointment")
	public ResponseEntity<Appointment> updateAppointment(@Valid @RequestBody Appointment app) throws AppointmentException{
		Appointment app1 = appService.updateAppointment(app);
		return new ResponseEntity<>(app1,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/appointment/{id}")
	public ResponseEntity<Boolean> delAppointment(@PathVariable("id")Long id)throws AppointmentException{
		boolean app1 = appService.deleteAppointment(id);
		
		return new ResponseEntity<>(app1,HttpStatus.OK);
	}
	
}
