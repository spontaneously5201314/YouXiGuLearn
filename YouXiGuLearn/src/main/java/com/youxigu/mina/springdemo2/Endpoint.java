package com.youxigu.mina.springdemo2;

public interface Endpoint {

	public void send(byte[] data);
	
	void receive(byte[] moMessage);

}
