package com.xywei.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xywei.config.MyConfig;
import com.xywei.service.DemoAnnotationService;
import com.xywei.service.DemoMethodService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MyConfig.class })
public class SpringTest {
	@Autowired
	private DemoAnnotationService annotationService;

	@Autowired
	private DemoMethodService demoMethodService;

	@Test
	public void test() {
		annotationService.add();
		demoMethodService.add();
		demoMethodService.sayHello();
	}
}
