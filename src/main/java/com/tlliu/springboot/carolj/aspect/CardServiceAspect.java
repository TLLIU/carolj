package com.tlliu.springboot.carolj.aspect;

import org.slf4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;

import com.tlliu.springboot.carolj.dto.ResultDTO;
import com.tlliu.springboot.carolj.utils.constants.StationErrorCodeConstants;
import com.tlliu.springboot.carolj.utils.execption.StationErrorCodeException;

@Aspect
public class CardServiceAspect {
    private final Logger logger = LoggerFactory.getLogger("card");
    // 切入点表达式按需配置
    @Pointcut("execution(* *.*(..)))")
    private void myPointcut() {
    }

    @Before("execution(* *.*(..)))")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.warn(className + "::" + methodName + "is executing");
        Object[] args = joinPoint.getArgs();
        StringBuilder log = new StringBuilder("Paramters: ");
        for (Object arg : args) {
            log.append(arg + " ");
        }
        logger.warn(log.toString());
    }

    @AfterReturning(value = "execution(* *.*(..)))", returning = "returnVal")
    public void afterReturin(Object returnVal) {
        logger.warn("方法正常结束了,方法的返回值:" + returnVal);
    }

    @AfterThrowing(value = "CardServiceAspect.myPointcut()", throwing = "e")
    public void afterThrowing(Throwable e) {
        if (e instanceof StationErrorCodeException) {
            logger.error("通知中发现异常StationErrorCodeException", e);
        } else {
            logger.error("通知中发现未知异常", e);
        }
    }

    @Around(value = "CardServiceAspect.myPointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.warn("前置增强...");
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            ResultDTO resultDTO = new ResultDTO();
            if (e instanceof StationErrorCodeException) {
                StationErrorCodeException errorCodeException = (StationErrorCodeException) e;
                resultDTO.setSuccess(false);
                resultDTO.setErrorCode(errorCodeException.getErrorCode().getErrorCode());
                resultDTO.setErrorMessage(errorCodeException.getErrorCode().getErrorMessage());
            } else {
                resultDTO.setSuccess(false);
                resultDTO.setErrorCode(StationErrorCodeConstants.STA10001.getErrorCode());
                resultDTO.setErrorMessage(StationErrorCodeConstants.STA10001.getErrorMessage());
            }
            return resultDTO;
        }
        return result;
    }
}
