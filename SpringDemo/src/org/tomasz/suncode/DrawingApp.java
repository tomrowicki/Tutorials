package org.tomasz.suncode;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class DrawingApp {

	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml")); // simpler albeit less powerful way to do things
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // more powerful and at the same time no more resource hungry way; requires spring.xml in the source folder!!!
		//Triangle triangle = (Triangle) factory.getBean("triangle"); // reference to spring.xml
		Triangle triangle = (Triangle) context.getBean("triangle");
		triangle.draw();
		
	}

}
