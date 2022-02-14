package com.example.springstudy.aspectstudy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    @Around("@annotation(PerfLogging))")
    public Object logPerfByAnnotation(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();

        Object retVal = pjp.proceed();
        System.out.println(pjp.getSignature().getName() + " : " + (System.currentTimeMillis() - begin) + "ms");

        return retVal;
    }



//    @Around("execution(* test*(..))")
//    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
//        long begin = System.currentTimeMillis();
//
//        Object retVal = pjp.proceed();
//
//        System.out.println(System.currentTimeMillis() - begin);
//
//        return retVal;
//    }

//    @Around("within(com.example.*)")
////    public Object test(ProceedingJoinPoint pjp) throws Throwable {
////
////        Object proceed = pjp.proceed();
////
////        return proceed;
////    }
}
