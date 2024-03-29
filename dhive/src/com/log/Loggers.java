package com.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import com.biz.CarStatus;
import com.biz.Click;
@Service
@Aspect
public class Loggers {
	private Logger car_log = 
			Logger.getLogger("car"); 
	private Logger work_log = 
			Logger.getLogger("user"); 
	private Logger data_log = 
			Logger.getLogger("data"); 
	
	
	
	// before
	@Before("execution(* com.biz.CarBiz.*(..))")
	public void logging3(JoinPoint jp) {
		Object[] args = jp.getArgs();
		CarStatus cstatus= (CarStatus)args[0];
		car_log.debug(jp.getSignature().getName()+","+cstatus.getId()+","+cstatus.getSpeed()+","+cstatus.getTemp()+","+cstatus.getOiltemp()+","+cstatus.getRpm());
		System.out.println(jp.getArgs());
	}
	// before
	@Before("execution(* com.biz.ShopBiz.*(..))")
	public void logging1(JoinPoint jp) {
		Object[] args = jp.getArgs();
		Click click= (Click)args[0];
		data_log.debug(jp.getSignature().getName()+","+click.getId()+","+click.getItem()+","+click.getPrice()+","+click.getAge()+","+click.getGender());
		System.out.println(jp.getArgs());
	}
	// before
	@Before("execution(* com.*.MainController.*(..))")
	public void logging2(JoinPoint jp) {
		work_log.debug(jp.getSignature().getName()+","+"ABC");
	}

	
}





