package com.guhao.reflect.test;

import java.lang.annotation.Annotation;
import java.lang.invoke.MethodType;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

import com.guhao.reflect.annotation.TestAn;
import com.guhao.reflect.dest.TargetAnnotationClass;
import com.guhao.reflect.dest.TargetMethodClass;

public class ReflectTest {
	
	/**
	 * 测试反射创建的三种方式
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@Test
	public void test1() throws Exception {
		//反射方式1
		Class<?> clazz = Class.forName("com.guhao.reflect.target.TargetClass");
		TargetAnnotationClass instance = (TargetAnnotationClass)clazz.newInstance();
		
		Assert.assertSame("world", instance.targetM());
		
		
		//反射方式2
		TargetAnnotationClass instance2 = TargetAnnotationClass.class.newInstance();
		
		Assert.assertSame("world", instance2.targetM());
		
		//反射方式3
		TargetAnnotationClass target = new TargetAnnotationClass();
		TargetAnnotationClass instance3 = target.getClass().newInstance();
		
		Assert.assertSame("world", instance3.targetM());
	}
	
	/**
	 * 测试通过反射获取属性
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Class<?> clazz = Class.forName("com.guhao.reflect.target.TargetUserClass");
		Object instance = clazz.newInstance();
		Field field = clazz.getDeclaredField("username");//获取private属性
		field.setAccessible(true);//设置允许访问
		field.set(instance, "guhao");
		System.out.println(instance);
		
		
		Field field2 = clazz.getField("test");//获取public属性
		field2.set(instance, "test");
		System.out.println(instance);
		
		Field field3 = clazz.getDeclaredField("sex");//获取protected属性
		field3.setAccessible(true);//设置允许访问
		field3.set(instance, "test");
		System.out.println(instance);
		
	}
	
	/**
	 * 通过反射获取方法调用
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Class<?> clazz = Class.forName("com.guhao.reflect.target.TargetMethodClass");
		Object instance = clazz.newInstance();
		Method method = clazz.getMethod("m1", String.class,Integer.class);//获取public方法
		method.invoke(instance, "zhangsan",24);
		
		Method[] methods = clazz.getMethods();//获取所有public方法
		methods[0].invoke(instance, "lisi",23);
		
		
		TargetMethodClass instance2 = (TargetMethodClass) clazz.getConstructor().newInstance();
		System.out.println(instance2);
		
		
		Method method2 = clazz.getDeclaredMethod("m2", String.class,Integer.class);//获取private方法
		method2.setAccessible(true);//设置允许访问
		method2.invoke(instance, "wangwu",25);

		Method method3 = clazz.getEnclosingMethod();
		method3.invoke(instance);
		
	}
	
	
	/**
	 * 通过反射获取注解
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Class<?> clazz = Class.forName("com.guhao.reflect.target.TargetAnnotationClassImpl");
		Object instance = clazz.newInstance();
		AnnotatedType[] annotatedTypes = clazz.getAnnotatedInterfaces();
		clazz.getAnnotations();//获取当且类和所有父类上声明的所有注解
		clazz.getDeclaredAnnotations();//获取当前类上声明的所有注解
		System.out.println(annotatedTypes);
	}
	
	
	
}
