package com.ssafy.myboard.board.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myboard.board.model.dto.Idol;
import com.ssafy.myboard.board.model.service.IdolService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("idol")
@Tag(name = "IdolController(아이돌 관리 컨트롤러)", description = "아이돌 정보를 관리하는 클래스입니다.")
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
	@Operation(
			summary = "아이돌 전체 목록 조회",
			description = "모든 아이돌 목록을 반환합니다.",
			responses = {
				@ApiResponse(responseCode = "200", description = "조회 성공"),	
				@ApiResponse(responseCode = "204", description = "조회된 데이터가 없음"),	
				@ApiResponse(responseCode = "500", description = "서버 실행시 에러")	
			}
	)
	public ResponseEntity<List<Idol>> list() {
		// 리스트 데이터를 브라우저에서 사용하기 위해 JSON으로 변환해 전송해야 한다.
		// JACKSON 라이브러리가 객체를 JSON으로 자동 변환해준다.
		ResponseEntity responseEntity;

		try {
			List<Idol> list = idolService.list(); // Idol 리스트 조회
			if (list.isEmpty()) {
				responseEntity = new ResponseEntity<>(list, HttpStatus.NO_CONTENT); // 데이터가 없을 때
			} else {
				HttpHeaders headers = new HttpHeaders();
				headers.add("mykey", "abcde12345");
				responseEntity = new ResponseEntity<>(list, headers, HttpStatus.OK); // 데이터가 있을 때
			}
		} catch (Exception e) {
			// 에러 발생 시 서버 오류 반환
			responseEntity = new ResponseEntity<>("문제가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	/*
	 * 정상일 경우 200 요청 번호에 해당하는 데이터가 없을 경우 204
	 */
//	idol/2
	@GetMapping("{no}")
	@Operation(
//			hidden = true,
			summary = "아이돌 상세 조회",
			description = "번호에 해당하는 아이돌의 상세 정보를 반환합니다.",
			responses = {
					@ApiResponse(responseCode = "200", description = "정상 조회"),
					@ApiResponse(responseCode = "204", description = "데이터가 존재하지 않음")
			},
			parameters = {
					@Parameter(
							name = "no", 
							description = "아이돌 번호",
							required = true	
					)
			}
	)
	public ResponseEntity<Idol> detail(@PathVariable int no) {
		Idol idol = idolService.getIdolByPK(no);

		if (idol == null) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			return ResponseEntity.noContent().build();
		}

		// 기존 객체 생성 방식
//		return new ResponseEntity<>(idol, HttpStatus.OK);

		// Builder 형태 권장
//		return ResponseEntity.status(HttpStatus.OK).body(idol);
		return ResponseEntity.ok(idol);
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
