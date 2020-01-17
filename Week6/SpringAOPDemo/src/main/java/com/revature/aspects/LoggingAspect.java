package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static Logger log = LogManager.getLogger(LoggingAspect.class);
	
	@Before("within(com.revature.models.*)")
	public void logModelMethods(JoinPoint jp) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
	}
}
