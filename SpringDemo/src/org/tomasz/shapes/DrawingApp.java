package org.tomasz.shapes;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class DrawingApp {

	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml")); // simpler albeit less powerful way to do things
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // more powerful and at the same time no more resource hungry way; requires spring.xml in the source folder!!!
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// this allow for the registration of the moment when a bean is about to get destroyed
		context.registerShutdownHook();
		//Triangle triangle = (Triangle) factory.getBean("triangle"); // reference to spring.xml
//		Triangle triangle = (Triangle) context.getBean("triangle-alias");
        Triangle triangle = (Triangle) context.getBean( "triangle1" );
		triangle.draw();
		
		// works for any class implementing the Shape interface
		Shape shape = (Shape) context.getBean("circle");
		shape.draw();
	}

}
