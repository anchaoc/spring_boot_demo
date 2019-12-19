package com.ac.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/** 用户切面
 * @author anchao
 */
@Aspect
@Slf4j
@Component
public class UserAspect {

//    @Pointcut("execution(* com.ac.service.impl.*.*(..))")
//    public void userPointcut(){}
//
//    @Before("userPointcut()")
//    public void user( ){
//        log.warn("Before 切入点-->"+this.getClass().getName());
//    }
//
//    @AfterReturning(pointcut = "userPointcut()",returning = "returnValue")
//    public void queryUserAfterReturning(Object returnValue){
//        log.warn("AfterReturning 切入点 returnValue-->"+returnValue);
//    }
//
//    @AfterThrowing(pointcut = "userPointcut()",throwing = "e")
//    public void queryUserAfterReturning(Exception e){
//        log.warn("AfterThrowing 切入点 e-->"+e.getMessage());
//    }
//
//    @After("userPointcut()")
//    public void userA( ){
//        log.warn("After 切入点-->"+this.getClass().getName());
//    }
//
//    @Around("userPointcut()")
//    public Object userAr(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        Object proceed = proceedingJoinPoint.proceed();
//        log.warn("Around 切入点-->"+proceed);
//        return proceed;
//    }
}
