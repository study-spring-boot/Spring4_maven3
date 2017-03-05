package com.xywei.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xywei.config.MyConfig;
import com.xywei.service.DemoBean;
import com.xywei.service.DemoService;;

@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:com/xywei/config/test.properties")
@ContextConfiguration(classes = { MyConfig.class })
public class SpringTest1 {
	@Autowired
	private DemoBean demoBean;

	@Autowired
	private DemoService demoService;

//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}

	@Value("${book.name}")
	private String authorName;

	@Test
	public void test1() {
		 System.out.println(authorName);
		System.out.println(demoService.getAnother());
		demoBean.test();
	}

}
