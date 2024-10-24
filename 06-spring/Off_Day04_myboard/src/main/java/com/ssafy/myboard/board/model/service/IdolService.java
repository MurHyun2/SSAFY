package com.ssafy.myboard.board.model.service;

import java.util.List;

import com.ssafy.myboard.board.model.dto.Idol;

public interface IdolService {
	List<Idol> list();
	
	Idol getIdolByPK(int no);
	
	void removeIdol(int no);

	void registIdol(Idol idol);

	void modifyIdol(Idol idol);
}
