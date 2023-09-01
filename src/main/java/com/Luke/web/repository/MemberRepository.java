package com.Luke.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.Luke.web.entity.Member;

public interface MemberRepository extends Repository<Member, Long> {

	List<Member> findAll();

	void save(Member member);

	List<Member> findTop5ByOrderByMnoDesc();

	//@Query(value = "SELECT count(*) FROM jmember j WHERE j.mid=?1 AND j.mpw=?2", nativeQuery = true)
	@Query(value="select count(*) from jmember j where j.mid=?1 and j.mpw=?2", nativeQuery = true)
	int count(String id, String pw);

	Member findById(String string);

	Member findByIdAndPw(String id, String pw);

}