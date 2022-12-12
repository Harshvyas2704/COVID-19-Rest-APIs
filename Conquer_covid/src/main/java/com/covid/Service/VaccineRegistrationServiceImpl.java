package com.covid.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.Model.Member;
import com.covid.Model.VaccineRegistration;
import com.covid.Repositry.MemberDao;
import com.covid.Repositry.VaccineRegistrationDao;
import com.covid.Exception.MemberException;
import com.covid.Exception.VaccineRegistration_Excepton;

@Service
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService {

	@Autowired
	private VaccineRegistrationDao VRrepo;

	@Autowired
	private MemberDao memberDao;

	@Override
	public VaccineRegistration getVaccineRegistration(String mobileno) throws VaccineRegistration_Excepton {
		// TODO Auto-generated method stub
		Optional<VaccineRegistration> optional = VRrepo.findById(mobileno);

		if (optional.isPresent())

			return optional.get();
		else
			throw new VaccineRegistration_Excepton("member not found with Molile :" + mobileno);
	}

	@Override
	public List<VaccineRegistration> getallMember() throws MemberException {
		List<VaccineRegistration> vaccineRegistration = VRrepo.findAll();

		if (vaccineRegistration.size() == 0)
			throw new MemberException("No Member found ");
		else
			return vaccineRegistration;

	}

	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration reg) throws VaccineRegistration_Excepton {
		Member mem = reg.getMember();
		mem.setVaccineRegisteration(reg);
		VaccineRegistration registrationAdded = VRrepo.save(reg);
		if (registrationAdded != null)
			return registrationAdded;

		else
			throw new VaccineRegistration_Excepton("Registration not added");
	}

	@Override
	public VaccineRegistration updatemember(VaccineRegistration reg) throws VaccineRegistration_Excepton {

		Optional<VaccineRegistration> optional = VRrepo.findById(reg.getMobileNo());

		if (optional.isPresent()) {

			VaccineRegistration updatememberDetails = VRrepo.save(reg);
			return updatememberDetails;

		} else
			throw new VaccineRegistration_Excepton("Invalid member details..");

	}

	@Override
	public boolean deletemember(String id) throws VaccineRegistration_Excepton {
		Optional<VaccineRegistration> optional = VRrepo.findById(id);
		if (optional.isPresent()) {

			VaccineRegistration existingmember = optional.get();
			VRrepo.delete(existingmember);

			return existingmember != null;

		} else
			throw new VaccineRegistration_Excepton("Member does not exist with Mobile No ....");

	}
}