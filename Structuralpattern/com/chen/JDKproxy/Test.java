package com.chen.JDKproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * <b>代理测试类<b>
 * @author 威 
 * <br>2017年9月4日 下午5:22:45 
 *
 */
public class Test {
	public static void main(String[] args){
		//目标对象
		final Singer target = new Singer() ;
		//代理对象
		ISinger proxy =  (ISinger) java.lang.reflect.Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler(){
			public Object invoke(Object object, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
				System.out.println("互动...") ;
				Object returnValue = method.invoke(target, args) ; //调用目标对象的sing方法
				System.out.println("谢谢大家") ;
			    return returnValue ;
			}
		}) ;
		//代理对象调用sing
		proxy.sing() ;
	}
}
