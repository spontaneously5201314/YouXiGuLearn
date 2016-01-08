package com.youxigu.mina.codec;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class MyCodecFactory implements ProtocolCodecFactory {

	private final MyEncoder encoder;

	private final MyDecoder decoder;

	public MyCodecFactory() {
		this(Charset.defaultCharset());
	}

	public MyCodecFactory(Charset charset) {
		this.encoder = new MyEncoder(charset);
		this.decoder = new MyDecoder(charset);
	}

	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		return this.decoder;
	}

	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		return this.encoder;
	}

}
