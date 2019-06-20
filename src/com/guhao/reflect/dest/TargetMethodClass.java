package com.guhao.reflect.dest;

public class TargetMethodClass {
	public void m1(String name,Integer age) {
		System.out.println("name:"+name+"\nage:"+age);
	}
	
	@SuppressWarnings("unused")
	private void m2(String name,Integer age) {
		System.out.println("name:"+name+"\nage:"+age);
	}
	
	public void m3() {
		new TargetInterface() {
			@Override
			public void sayHello(String name) {
				System.out.println("hello"+name);
			}
		};
	}
}
