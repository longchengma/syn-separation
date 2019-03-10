package com.home.retry;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Component;

/**
 * Created by li.ma on 2019/2/21.
 */
@Aspect
@Component
public class RetryAspect {
    public static final int MAX_RETRY_TIMES = 5 ; //max retry times

    @Pointcut(value = "@annotation(com.home.retry.RetryOnFailure)")
    public void retryOnFailure(){}

    @Around("retryOnFailure()")
    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
        int attempts = 0;
        do {
            attempts++;
            try {
                pjp.proceed();
            } catch(Exception e) {
                if(e instanceof ObjectOptimisticLockingFailureException) {
                    if(attempts > MAX_RETRY_TIMES) {
                        throw e;
                    }
                }
            }
        } while(attempts < MAX_RETRY_TIMES);

        return null;
    }
}
