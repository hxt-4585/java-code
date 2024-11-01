package com.powernode.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {
    @Pointcut("execution(* com.powernode.spring6.service..save*(..))")
    public void savePointCut(){}

    @Pointcut("execution(* com.powernode.spring6.service..delete*(..))")
    public void deletePointcut(){}

    @Pointcut("execution(* com.powernode.spring6.service..modify*(..))")
    public void modifyPointcut(){}

    @Before("savePointCut() || deletePointcut() || modifyPointcut()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("XXX操作员正在操作" + joinPoint.getSignature().getName() + "方法");
    }
}
