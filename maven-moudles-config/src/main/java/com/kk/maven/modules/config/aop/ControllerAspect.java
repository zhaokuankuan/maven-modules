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

/** AOP的文件
 * @author :Mr.kk
 * @date: 2018/9/10 13:27
 */
@Component
@Aspect
public class ControllerAspect {


    /***
    execution()是最常用的切点函数，其语法如下所示：

    整个表达式可以分为五个部分：

    1、execution(): 表达式主体。

    2、第一个*号：表示返回类型， *号表示所有的类型。

    3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。

    4、第二个*号：表示类名，*号表示所有的类。

    5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
     **/


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
