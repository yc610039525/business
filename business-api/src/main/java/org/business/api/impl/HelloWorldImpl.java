package org.business.api.impl;

import org.business.api.HelloWorldI;

/**
 * Hello world!
 *
 */
public class HelloWorldImpl implements HelloWorldI
{
  public String sayHi(String name){
	  return "hello "+name;
  } 
  
}
