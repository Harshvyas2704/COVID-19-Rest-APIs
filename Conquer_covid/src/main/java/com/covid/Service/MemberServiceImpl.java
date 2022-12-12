package com.covid.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.covid.Exception.MemberException;
import com.covid.Exception.VaccineRegistration_Excepton;
import com.covid.Model.Member;
import com.covid.Model.VaccineRegistration;
import com.covid.Repositry.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public List<Member> getAllMember() throws MemberException {
		// TODO Auto-generated method stub
		List<Member> MemberList = memberDao.findAll();
		
				if (MemberList.isEmpty()) {
		
					throw new MemberException("No data found....");
		
				} else {

					return MemberList;

				}
	}

	@Override
	public Member getMemberById(Integer idcardid) throws MemberException {
		Optional<Member> optional = memberDao.findById(idcardid);

		if (optional.isPresent()) {

			Member member = optional.get();

			return member;

		} else {

			throw new MemberException("Member not found with this Id : " + idcardid);

		}

	
		
	}

	@Override
	public Member addMember(Member member) throws MemberException {
		Member newmember = memberDao.save(member);
		
		if(newmember == null) throw new MemberException("Try Again....You submit empty form ");
		
		return newmember;
	}

	@Override
	public Member updatemember(Member member) throws MemberException {
		
     Optional<Member> optional= memberDao.findById(member.getId());
		
		if(optional.isPresent()) {
			
			Member updatedmember= memberDao.save(member);
			return updatedmember;
			
		}else
			throw new MemberException("Invalid Member details..");
		
		
		
		
	}

	@Override
	public boolean deletemember(Integer id) throws MemberException {

		Optional<Member> optional = memberDao.findById(id);

		if (optional.isPresent()) {

			Member deleteMember = optional.get();

			   memberDao.delete(deleteMember);

					return true;
         } else {
			throw new MemberException("member not found with this id: " + id);
		}
	}
	
	@Override
	public Member getPanCardByNumber(String panNo) throws MemberException  {
		 List<Member> list = memberDao.findByPanNo(panNo);
		 if(list.isEmpty()) throw new MemberException("please Enter Valid Adhar No."); 
			
		 return list.get(0);
	}

	@Override
	public Member getMemberAdharNo(String adharno) throws MemberException {
		 List<Member> list = memberDao.findByAdharNo(null);
		 if(list.isEmpty())throw new MemberException("please Enter Valid Adhar No."); 
		 
		 return list.get(0);
	}
	

	

	
}
