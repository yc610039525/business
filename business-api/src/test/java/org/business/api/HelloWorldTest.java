package org.business.api;

import static org.junit.Assert.*;

import org.business.api.impl.HelloWorldImpl;
import org.business.test.common.SpringTestCase;
import org.junit.Test;

public class HelloWorldTest extends SpringTestCase {

	@Test
	public void testSayHi() {
		//fail("Not yet implemented");
		HelloWorldI HelloWorld = (HelloWorldImpl)context.getBean("HelloWorld");
		System.out.println(HelloWorld.sayHi("JACK"));
		
	}

}
