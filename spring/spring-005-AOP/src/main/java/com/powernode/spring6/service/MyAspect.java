package com.powernode.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Before("execution(* com.powernode.spring6.service.OrderService.*(..))")
    public void beforeAdvice(){
        System.out.println("前置通知");
    }

    @Around("execution(* com.powernode.spring6.service.OrderService.*(..))")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知开始");
        // 执行目标方法
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知结束");
    }

    @AfterReturning("execution(* com.powernode.spring6.service.OrderService.*(..))")
    public void afterReturningAdvice(){
        System.out.println("后置通知");
    }

    @AfterThrowing("execution(* com.powernode.spring6.service.OrderService.*(..))")
    public void afterThrowingAdvice(){
        System.out.println("异常通知");
    }

    @After("execution(* com.powernode.spring6.service.OrderService.*(..))")
    public void afterAdvice(){
        System.out.println("最终通知");
    }
}
