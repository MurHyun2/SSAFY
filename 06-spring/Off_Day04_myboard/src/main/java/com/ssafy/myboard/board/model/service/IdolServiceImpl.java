package com.ssafy.myboard.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.myboard.board.model.dao.IdolDao;
import com.ssafy.myboard.board.model.dto.Idol;

@Service
public class IdolServiceImpl implements IdolService {

	private final IdolDao idolDao;

	public IdolServiceImpl(IdolDao idolDao) {
		this.idolDao = idolDao;
	}

	@Override
	public List<Idol> list() {
		return idolDao.selectIdol();
	}

	@Override
	public Idol getIdolByPK(int no) {
		return idolDao.selectIdolByPK(no);
	}

	@Override
	public void removeIdol(int no) {
		idolDao.deleteIdol(no);
	}

	@Override
	public void registIdol(Idol idol) {
		idolDao.insertIdol(idol);
	}

	@Override
	public void modifyIdol(Idol idol) {
		idolDao.updateIdol(idol);
	}
}
