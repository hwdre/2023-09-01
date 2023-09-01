package com.Luke.web.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.Luke.web.entity.JBoard;

public interface BoardRepository extends Repository<JBoard, Long>{

	void save(JBoard jb);

	List<JBoard> findAll();

	JBoard findByBno(int bno);

}
