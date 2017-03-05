package com.xywei.service;

import org.springframework.stereotype.Service;

/**
 * 通过使用方法规则进行拦截
 * @author wodoo
 *
 */
@Service
public class DemoMethodService {
	public void add(){
		System.out.println("---非代理方法拦截---");
	}
	public void sayHello(){
		System.out.println("第二个方法，hello");
	}
}
