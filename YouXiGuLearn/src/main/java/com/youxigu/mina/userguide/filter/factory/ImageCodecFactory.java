package com.youxigu.mina.userguide.filter.factory;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import com.youxigu.mina.userguide.filter.request.ImageRequestDecoder;
import com.youxigu.mina.userguide.filter.request.ImageRequestEncoder;
import com.youxigu.mina.userguide.filter.response.ImageResponseDecoder;
import com.youxigu.mina.userguide.filter.response.ImageResponseEncoder;

public class ImageCodecFactory implements ProtocolCodecFactory {

	private ProtocolEncoder encoder;
	private ProtocolDecoder decoder;

	public ImageCodecFactory(boolean client) {
		if (client) {
			encoder = new ImageRequestEncoder();
			decoder = new ImageResponseDecoder();
		} else {
			encoder = new ImageResponseEncoder();
			decoder = new ImageRequestDecoder();
		}
	}

	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		return encoder;
	}

	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		return decoder;
	}

}
