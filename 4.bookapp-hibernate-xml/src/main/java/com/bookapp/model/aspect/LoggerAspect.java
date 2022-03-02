package com.bookapp.model.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
	
	private Logger logger=LoggerFactory.getLogger(LoggerAspect.class);
	
	@Around("@annotation(com.bookapp.model.service.Loggable)")
	public Object printTimeTaken(ProceedingJoinPoint pjp) throws Throwable {
		long start=System.currentTimeMillis();
		Object result = pjp.proceed();
		long end=System.currentTimeMillis();
		logger.info("The time taken is  : "+(end-start)+" : "+pjp.getSignature());
		return result;
	}
	
}
