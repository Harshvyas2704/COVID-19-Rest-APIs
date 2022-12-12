package com.covid.Service;

import com.covid.Exception.AppointmentException;
import com.covid.Exception.MemberException;
import com.covid.Model.Appointment;
import com.covid.Model.Member;

public interface AppointmentService {

	public Appointment getAppointment(Long bookingid) throws AppointmentException;

	public Appointment addAppointment(Appointment app) throws AppointmentException;

	public Appointment updateAppointment(Appointment app) throws AppointmentException;

	public boolean deleteAppointment(Long id) throws AppointmentException;

}
