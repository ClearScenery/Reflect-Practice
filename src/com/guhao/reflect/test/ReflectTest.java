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
	 * ���Է��䴴�������ַ�ʽ
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@Test
	public void test1() throws Exception {
		//���䷽ʽ1
		Class<?> clazz = Class.forName("com.guhao.reflect.target.TargetClass");
		TargetAnnotationClass instance = (TargetAnnotationClass)clazz.newInstance();
		
		Assert.assertSame("world", instance.targetM());
		
		
		//���䷽ʽ2
		TargetAnnotationClass instance2 = TargetAnnotationClass.class.newInstance();
		
		Assert.assertSame("world", instance2.targetM());
		
		//���䷽ʽ3
		TargetAnnotationClass target = new TargetAnnotationClass();
		TargetAnnotationClass instance3 = target.getClass().newInstance();
		
		Assert.assertSame("world", instance3.targetM());
	}
	
	/**
	 * ����ͨ�������ȡ����
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Class<?> clazz = Class.forName("com.guhao.reflect.target.TargetUserClass");
		Object instance = clazz.newInstance();
		Field field = clazz.getDeclaredField("username");//��ȡprivate����
		field.setAccessible(true);//�����������
		field.set(instance, "guhao");
		System.out.println(instance);
		
		
		Field field2 = clazz.getField("test");//��ȡpublic����
		field2.set(instance, "test");
		System.out.println(instance);
		
		Field field3 = clazz.getDeclaredField("sex");//��ȡprotected����
		field3.setAccessible(true);//�����������
		field3.set(instance, "test");
		System.out.println(instance);
		
	}
	
	/**
	 * ͨ�������ȡ��������
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Class<?> clazz = Class.forName("com.guhao.reflect.target.TargetMethodClass");
		Object instance = clazz.newInstance();
		Method method = clazz.getMethod("m1", String.class,Integer.class);//��ȡpublic����
		method.invoke(instance, "zhangsan",24);
		
		Method[] methods = clazz.getMethods();//��ȡ����public����
		methods[0].invoke(instance, "lisi",23);
		
		
		TargetMethodClass instance2 = (TargetMethodClass) clazz.getConstructor().newInstance();
		System.out.println(instance2);
		
		
		Method method2 = clazz.getDeclaredMethod("m2", String.class,Integer.class);//��ȡprivate����
		method2.setAccessible(true);//�����������
		method2.invoke(instance, "wangwu",25);

		Method method3 = clazz.getEnclosingMethod();
		method3.invoke(instance);
		
	}
	
	
	/**
	 * ͨ�������ȡע��
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Class<?> clazz = Class.forName("com.guhao.reflect.target.TargetAnnotationClassImpl");
		Object instance = clazz.newInstance();
		AnnotatedType[] annotatedTypes = clazz.getAnnotatedInterfaces();
		clazz.getAnnotations();//��ȡ����������и���������������ע��
		clazz.getDeclaredAnnotations();//��ȡ��ǰ��������������ע��
		System.out.println(annotatedTypes);
	}
	
	
	
}
