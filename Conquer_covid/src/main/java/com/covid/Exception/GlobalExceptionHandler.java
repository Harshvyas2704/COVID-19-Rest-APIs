package com.covid.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AppointmentException.class)
	public ResponseEntity<MyErrorDetails> MyExceptionHandeler(AppointmentException ap, WebRequest req)
	{
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ap.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	
	//Member Exception Handler
	@ExceptionHandler(MemberException.class)
	public ResponseEntity<MyErrorDetails> MyExceptionHandeler(MemberException ap, WebRequest req)
	{
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ap.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	
//	Vaccination_center Exception Handler
	@ExceptionHandler(Vaccination_Center_Exception.class)
	public ResponseEntity<MyErrorDetails> MyExceptionHandeler(Vaccination_Center_Exception ap, WebRequest req)
	{
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ap.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	
		
	@ExceptionHandler(Vaccine_Exception.class)
	public ResponseEntity<MyErrorDetails> MyExceptionHandeler(Vaccine_Exception ap, WebRequest req)
	{
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ap.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(VaccineRegistration_Excepton.class)
	public ResponseEntity<MyErrorDetails> MyExceptionHandeler(VaccineRegistration_Excepton ap, WebRequest req)
	{
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ap.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	
	//for rest of Exceptiion
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> MyExceptionHandeler(Exception ap, WebRequest req)
	{
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ap.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	
	//for wrong URL request
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> MyExceptionHandeler(NoHandlerFoundException ap, WebRequest req)
	{
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ap.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
