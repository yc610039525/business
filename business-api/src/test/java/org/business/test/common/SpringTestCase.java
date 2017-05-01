package org.business.test.common;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTestCase {
	protected static ApplicationContext context = null;
	@BeforeClass
	public static void preHandler(){
		context = new ClassPathXmlApplicationContext("classpath*:spring*.xml");
	}
}
