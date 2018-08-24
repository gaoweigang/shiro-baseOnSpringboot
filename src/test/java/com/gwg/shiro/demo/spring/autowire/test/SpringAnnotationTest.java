package com.gwg.shiro.demo.spring.autowire.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * spring annotation 注入测试
 * 通常的情况下我们是将bean配置在spring的配置文件beans.xml里面，但我们也可以在Java类中配置
 * @author Administrator
 *
 */
@Configuration
public class SpringAnnotationTest {
	
	@Bean
	public Person getPerson(){
		return new Person("高伟刚", 22);
	}
	
	@Bean
	public Person person(){
		return new Person("高红程", 23);
	}
	
	/**
	 * 优先根据参数名称来装配，如果没有找到相应的，再根据类型来自动装配
	 */
	@Bean
	public PersonService personService(Person person){
		return new PersonService(person);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx =
		new AnnotationConfigApplicationContext(SpringAnnotationTest.class);
		PersonService personService = (PersonService) ctx.getBean("personService");
		System.out.println("人员姓名:"+personService.getPersonName());
	}
		

}
