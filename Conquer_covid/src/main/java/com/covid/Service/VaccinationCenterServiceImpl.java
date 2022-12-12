package com.covid.Service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.Exception.Vaccination_Center_Exception;
import com.covid.Model.Member;
import com.covid.Model.Vaccination_Center;
import com.covid.Model.Vaccine;
import com.covid.Repositry.VaccinationCenterDao;
import com.covid.Repositry.VaccineDao;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

	@Autowired
	private VaccinationCenterDao vRepo;

	@Autowired
	private VaccineDao VDao;

	@Override
	public List<Vaccination_Center> allVaccineCenter() throws Vaccination_Center_Exception {

		List<Vaccination_Center> list = vRepo.findAll();

		if (list.isEmpty()) {

			throw new Vaccination_Center_Exception("There are no center available");

		}
		return list;
	}

	@Override
	public Vaccination_Center getVaccineCenter(Integer centerid) throws Vaccination_Center_Exception {

		Optional<Vaccination_Center> opt = vRepo.findById(centerid);

		return opt.orElseThrow(() -> new Vaccination_Center_Exception("No Vaccine center found on Id : " + centerid));
	}

	
	
	
	@Override
	public Vaccination_Center addVaccineCenter(Vaccination_Center center, Integer Vid)
			throws Vaccination_Center_Exception {
		Optional<Vaccine> opt = VDao.findById(Vid);
		if (opt.isEmpty()) {
			throw new Vaccination_Center_Exception("there is no vaccine in this id" + Vid);
		}
		else
		{
			Vaccine vac =opt.get();
			vac.getCenters().add(center);
			Vaccine vacc = VDao.save(vac);
			center.setVaccine(vacc);
			
			Vaccination_Center saveCenter = vRepo.save(center);

			if (saveCenter == null) {
				throw new Vaccination_Center_Exception("Vaccine center not registerd");
			}

			return saveCenter;
		}
		

		// add exception -> if saveCenter is null then throw
	}

	@Override
	public boolean deleteCenter(Vaccination_Center center) throws Vaccination_Center_Exception {

		Optional<Vaccination_Center> opt = vRepo.findById(center.getCode());

		if (opt.isEmpty()) {
			throw new Vaccination_Center_Exception("Center Not Available to Delete -  please provide valid center ID");
		}

		vRepo.delete(opt.get());

		return true;

	}

	@Override
	public Vaccination_Center updateVaccineCenter(Vaccination_Center center) throws Vaccination_Center_Exception {

		Optional<Vaccination_Center> opt = vRepo.findById(center.getCode());

		if (opt.isEmpty()) {

			throw new Vaccination_Center_Exception("Center Not Available to Update");

		}

		Vaccination_Center vc = opt.get();

		return vRepo.save(vc); // will it save ?

	}

}