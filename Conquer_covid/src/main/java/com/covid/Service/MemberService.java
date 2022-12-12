package com.covid.Service;



import java.util.List;




import org.springframework.stereotype.Component;


import com.covid.Model.Member;
import com.covid.Exception.MemberException;



@Component
public interface MemberService {
	
	public List<Member> getAllMember()throws MemberException;
	
	
	public Member getPanCardByNumber(String panNo)throws MemberException;
	
	
	public Member getMemberAdharNo(String adharNo) throws MemberException;
	

	
	public Member getMemberById(Integer idcardid)throws MemberException;
	

	
	public Member addMember(Member member)throws MemberException;
	
	public Member updatemember(Member member) throws MemberException;
	
	public boolean deletemember(Integer id) throws MemberException;

	
	
	

}
