package com.kk.maven.modules.config.aop;

import com.kk.maven.modules.common.ReturnModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/** aop的文件
 * @author :Mr.kk
 * @date: 2018/9/10 13:27
 */
@Component
@Aspect
public class ControllerAspect {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.kk.web..*.*(..))")
    public  void log(){
        //设置切入点的方法名称，在底下进行实现
    }


    /** 测试接口  /orderTable/insert
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("log()")
    public Object  around(ProceedingJoinPoint joinPoint) throws Throwable{
        LOG.info("before method invoking!=====================================================");
        BindingResult bindingResult = null;
        for(Object arg:joinPoint.getArgs()){
            if(arg instanceof BindingResult){
                bindingResult = (BindingResult) arg;
            }
        }
        if(bindingResult != null){
            if(bindingResult.hasErrors()){
                String errorInfo="["+bindingResult.getFieldError().getField()+"]"+bindingResult.getFieldError().getDefaultMessage();
                LOG.info("errorInfo=========================================================="+errorInfo);
                return new ReturnModel(500, errorInfo);
            }
        }
        return joinPoint.proceed();
    }
}
