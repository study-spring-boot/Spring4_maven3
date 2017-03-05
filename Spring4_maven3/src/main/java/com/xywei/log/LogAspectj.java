package com.xywei.log;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.xywei.aop.MyAnnotation;

/**
 * 切面，模拟被调用的业务逻辑
 * 
 * @author wodoo
 *
 */
@Aspect
@Component
public class LogAspectj {
	@Pointcut("@annotation(com.xywei.aop.MyAnnotation)")
	public void annotationPointCut() {

	};

	/**
	 * 注解方式声明拦截
	 * 
	 */
//	@Before("annotationPointCut()")
	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method myMethod = signature.getMethod();
		MyAnnotation myAnnotation = myMethod.getAnnotation(MyAnnotation.class);
		System.out.println("----被代理注解拦截----" + myAnnotation.name());

	}

	/**
	 * 方法编程式拦截
	 */
	@After("execution(* com.xywei.service.DemoMethodService.*(..))")
//	@Before("execution(* com.xywei.service.DemoMethodService.add(..))")
	public void before(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("编程方式拦截," + method.getName());
	}

}
