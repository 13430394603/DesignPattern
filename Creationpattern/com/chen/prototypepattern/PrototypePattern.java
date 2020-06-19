package com.chen.prototypepattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * <b>原型模式<b>
 * @author 威 
 * <br>2017年9月28日 下午5:29:06 
 *
 */
public class PrototypePattern implements Cloneable, Serializable{
	private static final long serialVersionUID = 1L;
	private String string ;
	private SerializableObject obj ;
	private static PrototypePattern p = new PrototypePattern() ;
	public static PrototypePattern getInstance(){
		return p ;
	}
	private PrototypePattern(){
		
	}
	//浅复制
	public Object clone() throws CloneNotSupportedException{
		PrototypePattern proto = (PrototypePattern) super.clone() ;
		return proto ;
	}
	//深复制
	public Object deepClone() throws IOException, ClassNotFoundException{
		//写入当前对象的二进制流
		ByteArrayOutputStream bos = new ByteArrayOutputStream() ;
		ObjectOutputStream oos = new ObjectOutputStream(bos) ;
		oos.writeObject(this) ;
		
		//读出二进制流产生的新对象
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray()) ;
		ObjectInputStream ois = new ObjectInputStream(bis) ;
		return ois.readObject() ;
	}	
	public void setString(String string){
		this.string = string ;
	}
	public String getString() {
		return string ;
	}
	public void setObj(SerializableObject obj){
		this.obj = obj ;
	}
	public SerializableObject getObj(){
		return obj ;
	}
	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException{
		PrototypePattern p = PrototypePattern.getInstance() ;
		p.setString("yaya") ;
		SerializableObject s = new SerializableObject() ;
		System.out.println(p) ;
		System.out.println(s) ;
		p.setObj(s) ;
		PrototypePattern p1 = (PrototypePattern) p.clone() ;
		System.out.println("p.clone()"+p1+"-"+p1.getString()+"-"+p1.getObj()) ;
		PrototypePattern p2 = (PrototypePattern) p.deepClone() ;
		System.out.println("p.deepClone()"+p2+"-"+p2.getString()+"-"+p2.getObj()) ;
	}
}
/**
 * 
 * <b>作为测试参数类<b>
 * @author 威 
 * <br>2017年9月28日 下午9:21:14 
 *
 */
class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1L;
}  

