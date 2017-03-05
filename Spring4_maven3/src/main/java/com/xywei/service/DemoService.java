package com.xywei.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 需要被注入的bean
 * 
 * @author wodoo
 *
 */
@Service
public class DemoService {
	@Value("韦爵爷")
	private String another;

	public String getAnother() {
		return another;
	}

	public void setAnother(String another) {
		this.another = another;
	}

}
