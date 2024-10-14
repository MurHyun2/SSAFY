package com.ssafy.aop;

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class MyAspect {

	// 메서드 명은 중요치 않아 (직관적으로 보여주려고...)
	public void before() {
		System.out.println("컴퓨터를 부팅한다."); // 이전에 수행해야할 기능
	}

	public void afterReturning(int num) {
		System.out.println("Git에 Commit한다." + num + "줄을 (시간을)"); // 정상 마무리 기능
	}

	public void afterThrowing(Throwable th) {
		System.out.println("조퇴를 한다.");
		if (th instanceof OuchException) {
			((OuchException) th).handleException();
		}
	}

	public void after() {
		System.out.println("침대와 한몸이 된다.");
	}

	///////////////////////////
	public void around(MethodInvocationProceedingJoinPoint pjt) {
		int num = 0;

		this.before();
		try {
			num = (int) pjt.proceed();
			this.afterReturning(num);
		} catch (Throwable e) {
			this.afterThrowing(e);
		} finally {
			this.after();
		}
	}

}