package com.chen.brige;
/**
 * <b>测试桥接模式</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2020年6月19日 下午8:28:54 
 * @see
 * @since 1.0
 */
public class Test{
	public static void main(String[] args){
		Sourceable sub1 = new SourceSub1();
		MyBrige brige = new MyBrige(sub1);
		brige.method();

		Sourceable sub2 = new SourceSub2();
		brige = new MyBrige(sub2);
		brige.method();
	}
}

interface Sourceable{
	public void method(); 
}

class SourceSub1 implements Sourceable{
	public void method() {System.out.println("this is Sub1");}
}

class SourceSub2 implements Sourceable{
	public void method() {System.out.println("this is Sub2");}
}

class Brige implements Sourceable{
	private Sourceable source;
	public Brige(Sourceable source){
		this.source = source;
	}
	public void method(){
		source.method();
	}
}

class MyBrige extends Brige{
	public MyBrige(Sourceable source){
		super(source);
	}
}
