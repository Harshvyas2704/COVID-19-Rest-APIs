package com.covid.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.Exception.Vaccine_Exception;
import com.covid.Model.Vaccine;
import com.covid.Repositry.VaccineDao;

@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineDao vaccineDao;

	@Override
	public Vaccine getVaccineByName(String VaccninName) throws Vaccine_Exception {
		List<Vaccine> list = vaccineDao.findByVaccninName(VaccninName);

		if (list.size() == 0) {
			throw new Vaccine_Exception("No Vaccines available with Vaccine Name: " + VaccninName);

		}

		return (Vaccine) list;
	}

	@Override
	public Vaccine getVaccineById(Integer vaccineId) throws Vaccine_Exception {
		Optional<Vaccine> opt = vaccineDao.findById(vaccineId);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new Vaccine_Exception("No Vaccines are available with ID: " + vaccineId);
		}
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine) throws Vaccine_Exception {
	Vaccine list = vaccineDao.save(vaccine);

		if (list == null) {
			throw new Vaccine_Exception("No vaccines available");
		}
		return list;
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine) throws Vaccine_Exception {
		Optional<Vaccine> opt = vaccineDao.findById(vaccine.getVaccineId());

		if (opt.isPresent()) {

			return vaccineDao.save(vaccine);
		}

		else
			throw new Vaccine_Exception("No Vaccine Found to update");
	}

	@Override
	public Boolean deleteVaccine(Integer vid) throws Vaccine_Exception {
		Optional<Vaccine> opt = vaccineDao.findById(vid);

		if (opt.isPresent()) {
			Vaccine existingVaccine = opt.get();
			vaccineDao.delete(existingVaccine);
			return true;
		}

		throw new Vaccine_Exception("No Vaccine found to delete.. with ID: " + vid);
	}

}
