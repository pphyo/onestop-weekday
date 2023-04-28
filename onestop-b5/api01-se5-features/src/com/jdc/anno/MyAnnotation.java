package com.jdc.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyAnnotation {
	
	boolean name() default true;
	
	int value() default 0;
	
	String[] params();

}
