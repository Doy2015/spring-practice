package com.spring.practice.infra.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {


	@Pointcut("execution(* com.spring.practice.domain..*(..))")
	public void all() {
	}
	@Pointcut("execution(* com.spring.practice.domain..*Controller.*(..))")
	public void controller() {
	}
	@Pointcut("execution(* com.spring.practice.domain..*Service.*(..))")
	public void service(){}

	@Pointcut("execution(* com.spring.practice.domain..*Component.*(..))")
	public void component(){}

	@Pointcut("@annotation(com.spring.practice.infra.aspect.Loggable)")
	public void loggableMethods(){}

	@Around("all()")
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.currentTimeMillis();
			long timeMs = finish - start;
			log.info("log = {}, timeMs = {}ms" , joinPoint.getSignature(), timeMs);
		}
	}

	@Before("controller() || service() || component() || loggableMethods()")
	public void beforeLogic(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		String declaringTypeName = signature.getName();
//		log.info("method = {}()", declaringTypeName);

		StringBuilder logMessage = new StringBuilder();
		logMessage.append("method = ").append(declaringTypeName).append("()");
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			if(arg != null) {
				logMessage.append(", type = ").append(arg.getClass().getSimpleName()).append(", value = ").append(arg);
//				log.info("type = {}, value = {}", arg.getClass().getSimpleName(), arg);
			}

		}
		log.info(logMessage.toString());
	}
}
