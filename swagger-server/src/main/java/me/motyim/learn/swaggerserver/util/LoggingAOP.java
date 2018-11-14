package me.motyim.learn.swaggerserver.util;

import me.motyim.learn.swaggerserver.enums.LogStatus;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import static me.motyim.learn.swaggerserver.util.Logging.writeLog;


@Component
@Aspect
public class LoggingAOP {

    @Pointcut("execution(* me.motyim.learn.swaggerserver.service.*.*(..))")
    private void serviceLayerExecution(){}

    @Pointcut("execution(* me.motyim.learn.swaggerserver.apis.*.*(..))")
    private void restLayerExecution(){}


    @Around("serviceLayerExecution() || restLayerExecution()")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        writeLog(LogStatus.START , joinPoint);

        stopWatch.start();
        Object retVal = joinPoint.proceed();
        stopWatch.stop();

        writeLog(LogStatus.END,joinPoint,retVal,stopWatch.getTotalTimeMillis());

        return retVal;
    }


    @AfterThrowing(pointcut="serviceLayerExecution() || restLayerExecution()",throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        writeLog(LogStatus.Exception , joinPoint , ex);
    }

}
