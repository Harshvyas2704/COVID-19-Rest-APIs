package com.covid.Repositry;


import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.covid.Model.Member;
@Repository
public interface MemberDao extends JpaRepository<Member, Integer>{

	public List<Member> findByPanNo(String panNo);
	public List<Member> findByAdharNo(String adharNo);

}
