package com.youxigu.se.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
* @Description: 
* @author myg
* @time 2015年11月30日 下午6:28:02
*/
public class WhySerialversionUID {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		Person person = new Person();
//		person.setName("zhangsan");
//		ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream("F:\\person"));
//		ops.writeObject(person);
//		ops.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\person"));
		Object object = ois.readObject();
		System.out.println((Person)object);
	}
}
