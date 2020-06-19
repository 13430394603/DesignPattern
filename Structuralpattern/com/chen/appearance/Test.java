package com.chen.appearance;

/**
 * <b>外观模式测试</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2020年6月19日 下午8:22:56 
 * @see
 * @since 1.0
 */
public class Test {
	public static void main(String[] args){
		new Computer().startup() ;
	}
} 

class CPU{
	public void startup() {System.out.println("CPU start") ;} 
	public void shutdown() {System.out.println("CPU off") ;} 
}

class Memory{
	public void startup() {System.out.println("Memory start") ;} 
	public void shutdown() {System.out.println("Memory off") ;} 
}

class Disk{
	public void startup() {System.out.println("Disk start") ;} 
	public void shutdown() {System.out.println("Disk off") ;} 
}

class Computer {
	CPU cpu ;
	Memory memory ;
	Disk disk ;
	public Computer(){
		cpu = new CPU () ;
		memory = new Memory () ;
		disk = new Disk () ;
	}
	public void startup() {
		System.out.println("Computer start") ;
		cpu.startup() ;
		memory.startup() ;
		disk.startup() ;
	} 
	public void shutdown() {
		System.out.println("Computer off") ;
		cpu.shutdown() ;
		memory.shutdown() ;
		disk.shutdown() ;
	} 
}