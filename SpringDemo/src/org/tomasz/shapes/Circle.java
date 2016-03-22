package org.tomasz.shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape {

	private Point center;

	@Override
	public void draw() {
		System.out.println("Drawing Circle...");
		System.out.println("Center point is: " + center.getX() + ", " + center.getY());
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
	@Autowired
	// this is used if the id/name check also fails to connect with the appropriate bean
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}
}
