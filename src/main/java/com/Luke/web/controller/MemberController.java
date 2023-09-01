package com.Luke.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Luke.web.entity.Member;
import com.Luke.web.repository.MemberRepository;
import com.Luke.web.service.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	

	@GetMapping("/members")
	public String members(Model model) {
			
		//List<Member> list = memberRepository.findAll();
		List<Member> list = memberService.findTop5ByOrderByMnoDesc();
		//적어볼까요?
		
		model.addAttribute("list", list);
		return "members";
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member member, HttpSession session) {
		System.out.println(member);
		
		int count = memberService.count(member);
		System.out.println("카운트:" + count);
		
		if(count == 1) {
			Member result = memberService.findByIdAndPw(member);
			System.out.println("result:" + result);
			session.setAttribute("id", result.getId());
			session.setAttribute("name", result.getMname());
			return "index";
		} else {
			return "login";
		}
//		int count = memberService.count(member.getId(), member.getPw());
//		System.out.println("count: " + count);
//		Member result = memberService.findByIdAndPw(member.getId(), member.getPw());
//		System.out.println("result: " + result);
//		return "login";
	}
}
