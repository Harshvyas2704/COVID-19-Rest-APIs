package com.covid.Repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.covid.Model.Member;
import com.covid.Model.VaccineRegistration;
import com.covid.Service.VaccineRegistrationService;

@Repository
public interface VaccineRegistrationDao extends JpaRepository<VaccineRegistration, String>{

	@Query("select vr.member from VaccineRegistration vr where vr.mobileNo=:no")
	public Member getmemberByMobileNo(@Param("no") String no);

	

	
	
}
