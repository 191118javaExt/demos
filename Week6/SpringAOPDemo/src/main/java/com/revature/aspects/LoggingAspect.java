package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.models.Digimon;

@Aspect
@Component
public class LoggingAspect {

	private static Logger log = LogManager.getLogger(LoggingAspect.class);
	
	@Before("within(com.revature.models.*)")
	public void logModelMethods(JoinPoint jp) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
	}
	
	@AfterReturning(pointcut = "execution(String hug(int))", returning = "returnedObject")
	public void logHugs(JoinPoint jp, Object returnedObject) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature() + " returning " + returnedObject);
	}
	
	@AfterThrowing(pointcut = "execution(String hug(int))", throwing = "ex")
	public void logHugException(JoinPoint jp, Exception ex) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature() + " throwing " + ex.getClass(), ex);
	}
	
	@Around("execution(String hug(int))")
	public String logExceptions(ProceedingJoinPoint pjp) throws Throwable {
		Digimon d = (Digimon) pjp.getTarget();
		log.info(d + " is about to be hugged...");
		int closeness = (int) pjp.getArgs()[0];
		
		if(closeness > 4) {
			log.warn("Hug exceeding closeness level ... Back off");
			return null;
		} else {
			return (String) pjp.proceed();
		}
	}
}
