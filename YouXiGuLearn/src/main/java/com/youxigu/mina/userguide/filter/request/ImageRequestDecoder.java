package com.youxigu.mina.userguide.filter.request;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
//CumulativeProtocolDecoder将把你的解码器决定对连入数据可以做一些事情之前都缓存起来。在这种情况下消息具有固定大小，因此很容易等待所有的数据到齐以后再进行一些操作
public class ImageRequestDecoder extends CumulativeProtocolDecoder {

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {

		if (in.remaining() >= 12) {
			int width = in.getInt();
			int height = in.getInt();
			int numberOfCharachters = in.getInt();
			ImageRequest request = new ImageRequest(width, height, numberOfCharachters);
			out.write(request);
			return true;
		} else {
			return false;
		}

	}

}
