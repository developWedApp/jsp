package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
//@Aspect
public class AfterThrowingAdvice {

//	public void execptionLog() {
//		System.out.println("[예외 처리] 비즈니스 로직 수행 중 예외 발생");
//	}
	
	
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void execptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[예외 처리] " + method + "() 메소드 수행 중  예외발생");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적절한 값이 입력되었습니다.");
		} else if(exceptObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다.");
		} else if (exceptObj instanceof Exception) {
			System.out.println("문자게 발생하였습니다.");
		}
		
		
	}
}