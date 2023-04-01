package com.ibanking.app.model.service.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private final Logger logger = LogManager.getLogger();
    @Around("@annotation(com.ibanking.app.model.service.annotation.Log)")
    public Object applyLogging(ProceedingJoinPoint pjp)throws Throwable{
        long start=System.currentTimeMillis();

        Object value=pjp.proceed();

        long  end=System.currentTimeMillis();
        logger.info("time taken to execute method: "+ pjp.getSignature().getName() +" is : "+ (end-start) + "ms");
        return value;
    }
}
