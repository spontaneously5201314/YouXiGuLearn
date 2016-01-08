package com.youxigu.mina.codec;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import com.youxigu.mina.pojo.MyMessage;

public class MyDecoder extends CumulativeProtocolDecoder {
	private final Charset charset;

	public MyDecoder(Charset charset) {
		this.charset = charset;
	}

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		// TODO Auto-generated method stub
		// 创建解码器
		CharsetDecoder decoder = charset.newDecoder();
		// 设置容量和允许动态扩容
		IoBuffer buffer = IoBuffer.allocate(100).setAutoExpand(true);

		// 消息处理
		String statusLine = "", sender = "", receiver = "", length = "", msg = "";
		int matchCount = 0;
		int i = 1;
		while (in.hasRemaining()) {
			byte b = in.get();
			buffer.put(b);
			if (b == 10 && i < 5) {
				matchCount++;
				if (i == 1) {
					buffer.flip();
					statusLine = buffer.getString(matchCount, decoder);
					statusLine = statusLine.substring(0, statusLine.length() - 1);
					matchCount = 0;
					buffer.clear();
				}
				if (i == 2) {
					buffer.flip();
					sender = buffer.getString(matchCount, decoder);
					sender = sender.substring(0, sender.length() - 1);
					matchCount = 0;
					buffer.clear();
				}
				if (i == 3) {
					buffer.flip();
					receiver = buffer.getString(matchCount, decoder);
					receiver = receiver.substring(0, receiver.length() - 1);
					matchCount = 0;
					buffer.clear();
				}
				if (i == 4) {
					buffer.flip();
					length = buffer.getString(matchCount, decoder);
					length = length.substring(0, length.length() - 1);
					matchCount = 0;
					buffer.clear();
				}
				i++;
			} else if (i == 5) {
				matchCount++;
				if (matchCount == Long.parseLong(length.split(":")[1])) {
					buffer.flip();
					msg = buffer.getString(matchCount, decoder);
					buffer.clear();
					i++;
					break;
				}
			} else {
				matchCount++;
			}
		}
		MyMessage smsObj = new MyMessage();
		smsObj.setSender(sender.split(":")[1]);
		smsObj.setReceiver(receiver.split(":")[1]);
		smsObj.setMessage(msg);
		out.write(smsObj);
		return false;
	}

}
