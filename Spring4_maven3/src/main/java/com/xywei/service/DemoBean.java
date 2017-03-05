package com.xywei.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 * 演示使用spring el注入外部的值，包括字符串，资源类型
 * 
 * @author wodoo
 *
 */
@Service
@PropertySource("classpath:com/xywei/config/test.properties")
public class DemoBean {

	@Value("i love you")
	private String normal;

	@Value("#{systemProperties['os.name']}")
	private String osName;

	@Value("#{demoService.another}")
	private String fromAnother;

	@Value("classpath:com/xywei/config/test.properties")
	private Resource resource;

	@Value("www.baidu.com")
	private Resource url;

	// TODO 为什么就不能从properites文件里面注入了？需要标记PropertySourcesPlaceholderConfigurer 作为一个bean
	@Value("${book.name}")
	private String authorName;

	// @Autowired
	// private Environment environment;
	//
	// @Autowired
	// private PropertySourcesPlaceholderConfigurer configurer;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public void test() {
		System.out.println(normal);
		System.out.println(osName);
		System.out.println(fromAnother);
		System.out.println(authorName);
		// 无法使用IOUTILS？
		// System.out.println(IOUtils);
		try {
			System.out.println(resource.getInputStream());
			System.out.println(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
