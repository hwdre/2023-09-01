package com.Luke.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luke.web.entity.Member;
import com.Luke.web.repository.MemberRepository;



@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	/* 	findAll()	전체 가져오기
	* 	findOne()	하나 가져오기
	 * 	save()		저장하기 / 수정하기
	 * 	count()		
	 * 	delete()	
	 * 
	 */
	public List<Member> findTop5ByOrderByMnoDesc() {
		return memberRepository.findTop5ByOrderByMnoDesc();
	}

	public int count(String mid, String mpw) {
		return memberRepository.count(mid, mpw);
	}

	public Member findById(String string) {
		// TODO Auto-generated method stub
		return memberRepository.findById(string);
	}

	public Member findByIdAndPw(Member member) {
		// TODO Auto-generated method stub
		return memberRepository.findByIdAndPw(member.getId(), member.getPw());
	}

	public int count(Member member) {
		// TODO Auto-generated method stub
		return memberRepository.count(member.getId(), member.getPw());
	}

	

}
