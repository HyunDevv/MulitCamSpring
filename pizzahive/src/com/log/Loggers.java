package com.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import com.vo.MemberVO;
@Service
@Aspect
public class Loggers {
	private Logger car_log = 
			Logger.getLogger("car"); 
	private Logger work_log = 
			Logger.getLogger("user"); 
	private Logger data_log = 
			Logger.getLogger("data"); 
	private Logger pizza_log = 
			Logger.getLogger("pizza"); 
	
	
	

	@Before("execution(* com.biz.ClickBiz.*(..))")
	public void logging1(JoinPoint jp) {
		Object[] args = jp.getArgs();
		MemberVO member= (MemberVO)args[0];
		pizza_log.debug(member.getId()+","+member.getAge()+","+member.getGender()+","+member.getIt());
		System.out.println(jp.getArgs());
	}
//	// before
//	@Before("execution(* com.*.MainController.*(..))")
//	public void logging2(JoinPoint jp) {
//		work_log.debug(jp.getSignature().getName()+","+"ABC");
//	}

	
}





