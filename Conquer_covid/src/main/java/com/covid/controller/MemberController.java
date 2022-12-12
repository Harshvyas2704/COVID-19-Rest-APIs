package com.covid.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.Exception.MemberException;
import com.covid.Model.Member;
import com.covid.Service.MemberServiceImpl;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memSer;
	
	@GetMapping("/memebers")
	public ResponseEntity<List<Member>> getAllMemberHandeler() throws MemberException{
		
		List<Member> list = memSer.getAllMember();
		return new ResponseEntity<List<Member>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Member>getMemberByIdHandler(@Valid @PathVariable("id") Integer id) throws MemberException{
		
		Member mid = memSer.getMemberById(id);
		
		return new ResponseEntity<>(mid,HttpStatus.OK);
	}
	
	@GetMapping("/{adharNo}")
	public ResponseEntity<Member> getAadharNumberHandler(@Valid @PathVariable("adharNo") String aadharno) throws MemberException
	{
		Member memb = memSer.getMemberAdharNo(aadharno);
		
		return new ResponseEntity<Member>(memb,HttpStatus.OK);
	}
	
	@GetMapping("/{panNo}")
	public ResponseEntity<Member> getByPancardHandler(@Valid @PathVariable("panNo") String panNo) throws MemberException{
		
		Member mpan = memSer.getPanCardByNumber(panNo);
		
		
		return new ResponseEntity<Member>(mpan,HttpStatus.OK);	
	}
	
	@PutMapping("/update")
	public ResponseEntity<Member> UpdateMemberhandler(@Valid @RequestBody Member memb) throws MemberException{
		
		Member Upmem = memSer.updatemember(memb);
		
		return new ResponseEntity<Member>(Upmem,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> DeleteMemberHandler(@PathVariable("id") Integer id) throws MemberException{
		
		boolean Dmeme = memSer.deletemember(id);
		
		return new ResponseEntity<Boolean>(Dmeme,HttpStatus.OK);
	}
	

}
