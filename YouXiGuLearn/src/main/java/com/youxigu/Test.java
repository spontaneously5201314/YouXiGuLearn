package com.youxigu;
/**
* @Description 
* @author Spontaneously
* @time 2016年1月21日 下午4:25:21
*/
public class Test {

	public static void main(String[] args) {
		for(int i = 9; i < 10000; i++){
			if(i%2 == 1){
				if(i%3==0){
					if(i%4==1){
						if(i%5==4){
							if(i%6==3){
								if(i%7==0){
									if(i%8==1){
										if(i%9==0){
											System.out.println(i);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
