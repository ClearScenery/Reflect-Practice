package com.guhao.reflect.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = { ElementType.METHOD,ElementType.TYPE })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface TestAn {
	String name() default "";
}
