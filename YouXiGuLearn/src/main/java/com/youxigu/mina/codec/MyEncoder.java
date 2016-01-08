package com.youxigu.mina.codec;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import com.youxigu.mina.pojo.MyMessage;

public class MyEncoder extends ProtocolEncoderAdapter {

	private final Charset charset;

	public MyEncoder(Charset charset) {
		this.charset = charset;
	}

	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
		// 编码对象
		MyMessage smsObj = (MyMessage) message;
		// 获取编码器
		CharsetEncoder encoder = charset.newEncoder();
		// 设置容量和允许扩展
		IoBuffer buffer = IoBuffer.allocate(100).setAutoExpand(true);
		// 设置消息体
		String statusLine = "M sip:wap.fetion.com.cn SIP/C 2.0";
		String sender = smsObj.getSender();
		String receiver = smsObj.getReceiver();
		String smsContent = smsObj.getMessage();
		buffer.putString(statusLine + "\n", encoder);
		buffer.putString("S:" + sender + "\n", encoder);
		buffer.putString("R:" + receiver + "\n", encoder);
		buffer.putString("L:" + (smsContent.getBytes().length) + "\n", encoder);// 消息的长度
		buffer.putString(smsContent, encoder);

		buffer.flip();
		out.write(buffer);
	}
	

}
