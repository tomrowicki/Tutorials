package org.tomasz.shapes;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

// used to declare bean, instead of using xml, there's also Service, Repository, and Controller
// for marking different types of beans
@Component
public class Circle implements Shape {

	private Point center;
	
	@Autowired
	private MessageSource messageSource;

	@Override
	public void draw() {
		System.out.println("Drawing Circle...");
		System.out.println(messageSource.getMessage("drawing.point", new Object[] {center.getX(), center.getY()}, "Default drawing point message", null));
		System.out.println("Message from within a bean: " + messageSource.getMessage("greeting", null, "Default Message", null));
	}

	public Point getCenter() {
		return center;
	}

	// required properties are checked during initialization, the annotation
	// requires RequiredAnnotationBeanProcessor
	// to be declared in spring.xml
	// @Required
	// if only one object of the Point class is declared in spring.xml this will
	// autowire the property
	// to it; in the case of multiple objects it looks for the same id as the
	// name of the field; requires AutowiredAnnotationBeanPostProcessor
//	@Autowired
	// this is used if the id/name check also fails to connect with the appropriate bean
//	@Qualifier("circleRelated")
	// another way to autowire properties
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@PostConstruct
	public void initializeCircle() {
		System.out.println("Init of Circle");
	}
	
	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destruction of Circle");
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}
