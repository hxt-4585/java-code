package com.powernode.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {
    @Around("execution(* com.powernode.spring6.service..*(..))")
    public void aroundAspect(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("开启事务");
            proceedingJoinPoint.proceed();
            System.out.println("关闭事务");
        } catch (Throwable e) {
            System.out.println("回滚");
        }
    }
}
