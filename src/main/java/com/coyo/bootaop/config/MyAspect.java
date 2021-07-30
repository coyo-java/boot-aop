package com.coyo.bootaop.config;


import com.coyo.bootaop.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class MyAspect {



    @Around(value = "execution(* com.coyo.bootaop.service.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Aroundbefore通知被执行了");
        Object proceed = pjp.proceed();
        String str = proceed.toString()+"aroundafter";
        System.out.println("Aroundafter通知被执行了");
        return str;

    }
//
//    @After(value = "execution(* com.coyo.bootaop.service.*.*(..))")
//    public void after(){
//        System.out.println("After通知被执行了");
//    }

    @AfterReturning(value = "execution(* com.coyo.bootaop.service.*.*(..))",returning = "result")
    public void afterReturning(Object result){
        System.out.println("AfterReturning通知被执行了");
        User user = (User) result;
        user.setRealname("张小花");
        result = user;

    }

    @Before(value = "execution(* com.coyo.bootaop.service.*.*(..))")
    public void before(){
        System.out.println("Before通知被执行了");
    }
}
