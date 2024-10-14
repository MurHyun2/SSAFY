package com.ssafy.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 공통 기능 클래스 정의하기
@Aspect
@Component
public class PrjAspect {
	@Pointcut("execution (* com.ssafy.board.model.service.BoardServiceImpl.*(..))")
	public void pCut() {}
	
	
	@AfterReturning(value = "pCut()")
	public void after() {
		System.out.println("핵심 기능 메서드 정상 실행 후 호출되었음...");
	}
	
	@Before(value = "pCut()")
	public void log() {
		System.out.println("Time : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
