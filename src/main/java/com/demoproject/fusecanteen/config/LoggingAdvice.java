package com.demoproject.fusecanteen.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value="execution(* com.demoproject.fusecanteen.controller.*.*(..) )")
    public void applicationPointCut() {

    }

    @Around("applicationPointCut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().toString();
        Object[] objects = proceedingJoinPoint.getArgs();
        ObjectMapper mapper = new ObjectMapper();
        logger.info("Method Invocation: " + className + " : " + methodName + "()" + "arguments : " +
                mapper.writeValueAsString(objects));
        Object object = proceedingJoinPoint.proceed();
        logger.info(className + " : " + methodName + "() --> Response : " +
                mapper.writeValueAsString(object));
        return object;
    }
}
