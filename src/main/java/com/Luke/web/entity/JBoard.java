package com.Luke.web.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class JBoard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bno;
	
	@Column(name="btitle", length = 15)
	private String title;
	
	@Column(name="bcontent", columnDefinition = "mediumtext", length = 1000)
	private String content;
	
	@LastModifiedDate 
	@Column(columnDefinition="TIMESTAMP")
	private LocalDateTime bdate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="mno") //jpa에서 가장 기본적이고 어려운 부분입니다.
	private Member member;
}
