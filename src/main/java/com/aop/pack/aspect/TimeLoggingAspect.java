package com.aop.pack.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class TimeLoggingAspect {

    @Around("execution(* com.aop.pack.service.*.*(..))")
    public void userAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around: Before calculation-" + new Date());

        System.out.println("Method and It's class name : " + joinPoint.getSignature());

        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg : signatureArgs) {
            System.out.println("Arg: " + signatureArg);
        }

        joinPoint.proceed();
        System.out.println("@Around: After calculation-" + new Date());
    }

    @Before("execution(* com.aop.pack.service.*.*(..))")
    public void logBefore() {
        System.out.println("@Before:" + new Date());
    }

    @After("execution(* com.aop.pack.service.*.*(..))")
    public void logAfter() {
        System.out.println("@After:" + new Date());
    }

    @AfterThrowing(pointcut = "execution(* com.aop.pack.service.*.*(..))",
            throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        System.out.println("@AfterException:" + new Date());
        System.out.println("Exception caught:" + exception.getMessage());
    }

    @AfterReturning(pointcut = "execution(* com.aop.pack.service.*.*(..))",
            returning = "val")
    public void logAfterReturning(Object val) {
        System.out.println("Method return value:" + val);
        System.out.println("@AfterReturning:" + new Date());
    }
}
