package com.chen.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;


/**
 * @author: CHEN
 * @date: 2020-11-19 20:27
 **/
@Aspect
public class MyLogUtil {
    Log logger=null;
    /**
     * 方法执行前后拦截
     *
     * @param pjp
     * @return
     */
    @Before("@annotation(LogUtil)")
    public void before(JoinPoint pjp) {
        logger= LogFactory.getLog("");
        logger.info(pjp.getSignature().getName()+"------------------start");
    }
    @After("@annotation(LogUtil)")
    public void after(JoinPoint pjp) {
        logger= LogFactory.getLog("");
        logger.info(pjp.getSignature().getName()+"------------------result");
    }
}
