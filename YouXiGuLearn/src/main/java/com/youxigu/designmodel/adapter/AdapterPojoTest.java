package com.youxigu.designmodel.adapter;
//测试类  
public class AdapterPojoTest {

	public static void main(String[] args) {
		// 使用普通功能类  
        Target concreteTarget = new ConcreteTarget();  
        concreteTarget.request();  
          
        // 使用特殊功能类，即适配类，  
        // 需要先创建一个被适配类的对象作为参数  
        Target adapter = new AdapterPojo(new Adaptee());  
        adapter.request();  
	}
}
