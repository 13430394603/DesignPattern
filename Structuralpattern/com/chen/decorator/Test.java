package com.chen.decorator;

public class Test{
	public static void main(String[] args){
		Component cc = new ComponentA();
		Decorator decorator = new Decorator(cc);
		DecoratorStyle1 d1 = new DecoratorStyle1(decorator);
		DecoratorStyle2 d2 = new DecoratorStyle2(d1);
		d2.addStyle();
	}
}

//装饰器
class Decorator implements Component{
	private Component c;
	public Decorator(Component c){
		this.c = c;
	}
	public void addStyle(){
		c.addStyle();
	}
}

class DecoratorStyle1 extends Decorator{
	public DecoratorStyle1(Component c){
		super(c);
	}
	public void addStyle(){
		System.out.println("#############Style1############");
		super.addStyle();
		System.out.println("#############Style1############");
	}
	/*public void addNew(){
		System.out.println("装饰Style1样式");
	}*/
}

class DecoratorStyle2 extends Decorator{
	public DecoratorStyle2(Component c){
		super(c);
	}
	public void addStyle(){
		System.out.println("#############Style2############");
		super.addStyle();
		System.out.println("#############Style2############");
	}
	/*public void addNew(){
		System.out.println("装饰Style2样式");
	}*/
}

//组件接口
interface Component{
	public void addStyle();
}

class ComponentA implements Component{
	public void addStyle(){
		System.out.println("This is ComponentA");
	}
}

class ComponentB implements Component{
	public void addStyle(){
		System.out.println("This is ComponentB");
	}
}
