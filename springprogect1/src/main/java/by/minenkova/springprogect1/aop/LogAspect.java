package by.minenkova.springprogect1.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("@annotation(LogAnnotation)")
    //@Pointcut("execution(public * by.minenkova.springprogect1.controller.PersonController.*(..))")
    public void callAtPersonController() {
    }
    @Before("callAtPersonController()")
    public void beforeCallMethod(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        log.info("before " + jp.toString() + ", args=[" + args + "]");
    }@After("callAtPersonController()")
    public void afterCallAt(JoinPoint jp) {
        log.info("after " + jp.toString());
    }
    @Around("callAtPersonController()")
    public Object aroundCallAt(ProceedingJoinPoint call) throws Throwable{
        StopWatch clock=new StopWatch(call.toString());
        try {
            clock.start(call.toShortString());
            return call.proceed();
        }
        finally{
            clock.stop();
            System.out.println(clock.prettyPrint());
        }

    }
}
