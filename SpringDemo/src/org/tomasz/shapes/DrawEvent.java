package org.tomasz.shapes;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent{

	public DrawEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	// overriding the toString method
	public String toString() {
		return "Draw event occured!";
	}
}
