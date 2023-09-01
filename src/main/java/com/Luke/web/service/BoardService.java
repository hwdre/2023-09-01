package com.Luke.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Luke.web.entity.JBoard;
import com.Luke.web.repository.BoardRepository;


@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	public List<JBoard> findAll() {
		return boardRepository.findAll();
	}

	public void save(JBoard jBoard) {
		boardRepository.save(jBoard);
	}

	public JBoard detail(int bno) {
		// TODO Auto-generated method stub
		return boardRepository.findByBno(bno);
	}
}
