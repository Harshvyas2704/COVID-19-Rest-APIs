package com.covid.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.Model.Appointment;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Long>{

	
}
