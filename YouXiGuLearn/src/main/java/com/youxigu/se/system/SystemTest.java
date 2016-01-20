package com.youxigu.se.system;
/**
* @Description 
* @author Spontaneously
* @time 2016年1月13日 下午4:47:08
*/
public class SystemTest {

	public static void main(String[] args) {
//		System.setSecurityManager(new SecurityManager(){
//
//			@Override
//			public void checkExit(int status) {
//				super.checkExit(status);
//			}
//			
//		});
//		System.out.println(System.getSecurityManager());
		Demo demo = new Demo();
		System.out.println(demo.doCompute(0, 2));
	}
}
class Demo{
	public int doCompute(int x, int y){
		System.setSecurityManager(new SecurityManager(){

			@Override
			public void checkExit(int x) {
				super.checkExit(x);
			}
			
		});
		return x + y;
	}
}
