package com.guhao.reflect.dest;

import com.guhao.reflect.annotation.TestAn;
import com.guhao.reflect.annotation.TestAnSub;

@TestAnSub(name="clazz")
public class TargetAnnotationClass {
	
	@TestAn(name="hello")
	public String targetM() {
		return "world";
	}
}
