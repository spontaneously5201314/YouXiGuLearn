package com.youxigu.mina.userguide.filter;


import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.DefaultWriteRequest;
import org.apache.mina.core.write.WriteRequest;

import javassist.bytecode.analysis.Executor;

//假定实现一个将字符串转换为字符数组的过滤器
public class MyFilter extends IoFilterAdapter {

	@Override
	public void sessionOpened(NextFilter nextFilter, IoSession session) throws Exception {
		nextFilter.sessionOpened(session);
	}

	@Override
	public void messageSent(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
		nextFilter.messageSent(session, writeRequest);
	}

	@Override
	public void filterWrite(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
		nextFilter.filterWrite(session, new DefaultWriteRequest(((String) writeRequest.getMessage()).toCharArray(),
				writeRequest.getFuture(), writeRequest.getDestination()));
	}

	@Override
	public void sessionCreated(NextFilter nextFilter, IoSession session) throws Exception {
		nextFilter.sessionCreated(session);
//		Executor executor = new Executor(null, null);
//		executor.execute(arg0, arg1, arg2, arg3, arg4);
	}

}
