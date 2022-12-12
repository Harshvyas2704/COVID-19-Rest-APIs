package com.covid.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.covid.Exception.AppointmentException;
import com.covid.Exception.MemberException;
import com.covid.Exception.Vaccination_Center_Exception;
import com.covid.Model.Appointment;
import com.covid.Model.Member;
import com.covid.Model.Vaccination_Center;
import com.covid.Repositry.AppointmentDao;
import com.covid.Repositry.MemberDao;
import com.covid.Repositry.VaccinationCenterDao;
import com.covid.Repositry.VaccineRegistrationDao;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentDao appDao;
	
	
	@Autowired
	private MemberDao memDao;
	
	@Autowired
	private VaccinationCenterDao vacDao;
	
	@Autowired
	private VaccineRegistrationDao vacRDao;
	 
	@Override
	public Appointment getAppointment(Long bookingid) throws AppointmentException {
		Optional<Appointment> opt= appDao.findById(bookingid);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new AppointmentException("No appointment available for Booking ID: "+bookingid);
		}
	}
	
//	checking //////////////////////////////////////////////////////

	@Override
	public Appointment addAppointment(Appointment app) throws AppointmentException {
				
		Member mem =vacRDao.getmemberByMobileNo(app.getMobile_No());
		if(mem == null )
		{
			throw new AppointmentException("No member Found");
		}
		Vaccination_Center vac =vacDao.findByPinCode(mem.getPinCode());
		if(vac ==null)
		{
			throw new AppointmentException("There is no Vaccine center on this Pincode");
		}
		else
		{
			if(vac.getSlot()<10)
			{
				app.setBooking_Status(true);
				vac.setSlot(vac.getSlot()-1);
				 vacDao.save(vac);
				app.setVacCenter(vac);
			}
				
			 return appDao.save(app);
		}
		
			
		
		
	}

	@Override
	public Appointment updateAppointment(Appointment app) throws AppointmentException {
		Optional<Appointment> opt= appDao.findById(app.getBookingId());
		if(opt.isPresent()) {
			return appDao.save(app);
		}
		else {
			throw new AppointmentException("ID not found");
		}
	}

	@Override
	public boolean deleteAppointment(Long id) throws AppointmentException {
		Optional<Appointment> opt= appDao.findById(id);
		
		if(opt.isPresent()) {
			appDao.delete(opt.get());
			return true;
		}
		else {
			throw new AppointmentException("No id found");
		}
	}

}
