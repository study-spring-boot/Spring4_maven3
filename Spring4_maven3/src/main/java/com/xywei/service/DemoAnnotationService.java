package com.xywei.service;

import org.springframework.stereotype.Service;

import com.xywei.aop.MyAnnotation;

/**
 * 实现通过注解方式拦截
 * @author wodoo
 *
 */
@Service
public class DemoAnnotationService {

	@MyAnnotation(name = "自定义注解拦截的ADD操作")
	public void add() {
		System.out.println("非代理自定义注解拦截");
	}
}
