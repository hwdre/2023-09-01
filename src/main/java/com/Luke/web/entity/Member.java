package com.Luke.web.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//영속성(Persistence)

@Entity
@Data
@Table(name="jmember")
@NoArgsConstructor
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mno;
	
	@Column(length = 30)
	private String mname;
	
	@Column(name="mid", unique = true)
	private String id;
	
	@Column(nullable = false, name="mpw") //nullable = false는 notnull과 같습니다.
	private String pw;
	
	@Column(columnDefinition="TIMESTAMP")
	private LocalDateTime mjoindate;
}
