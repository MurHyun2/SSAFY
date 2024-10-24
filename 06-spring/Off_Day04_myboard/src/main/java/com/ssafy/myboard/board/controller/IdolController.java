package com.ssafy.myboard.board.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myboard.board.model.dto.Idol;
import com.ssafy.myboard.board.model.service.IdolService;

@RestController
@RequestMapping("idol")
public class IdolController {
	private final IdolService idolService;

	public IdolController(IdolService idolService) {
		this.idolService = idolService;
	}

//	응답
//	시작라인(200 HTTP/1.1 OK)
//	헤더		키 : 값
//			키 : 값
//	빈줄~
//	바디
//	
//	200 HTTP/1.1 OK
//	a:1
//	b:1
//	c:2
//	
//	d:3
//	공백으로 헤더와 바디를 구분
//	헤더 -> a : 1, b : 1, c : 2
//	바디 -> d : 3
//	
//	JSON
//	MAP : {}
//	DTO : {}
//	LIST, 배열 : []
//			
//	[{}, {}]
	@GetMapping
	public List<Idol> list() {
//		list 데이터를 브라우저에서 사용하도록 문자열로 변환해서 전송해줘야 한다.
//		객체를 변환하면 객체의 내용을 JSON으로 자동 변환 : JACKSON 라이브러리 사용
		List<Idol> list = idolService.list();
		return list;
	}

//	idol/2
	@GetMapping("{no}")
	public Idol detail(@PathVariable int no) {
		return idolService.getIdolByPK(no);
	}
	
	@DeleteMapping("{no}")
	public void remove(@PathVariable int no) {
		idolService.removeIdol(no);
	}
	
	@PostMapping
	public void regist(@RequestBody Idol idol) {
		idolService.registIdol(idol);
	}
	
	@PutMapping
	public void update(@RequestBody Idol idol) {
		idolService.modifyIdol(idol);
	}
}
