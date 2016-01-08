package com.youxigu.mina.springdemo1;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorHandler extends IoHandlerAdapter {

	private static final Logger LOG = LoggerFactory.getLogger(CalculatorHandler.class);

	private ScriptEngine jsEngine = null;

	public CalculatorHandler() {
		ScriptEngineManager seManager = new ScriptEngineManager();
		jsEngine = seManager.getEngineByName("JavaScript");

		if (jsEngine == null) {
			throw new RuntimeException("Can not find out the javascript engine.");
		}
	}

	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		LOG.warn(cause.getMessage(), cause);
	}

	public void messageReceived(IoSession session, Object message) throws Exception {
		String expression = message.toString();
		if ("exit".equalsIgnoreCase(expression.trim()) || "quit".equalsIgnoreCase(expression.trim())) {
			session.close(true);
			return;
		}
		try {
			Object result = jsEngine.eval(expression);
			session.write(result.toString());
		} catch (ScriptException e) {
			LOG.error(e.getMessage(), e);
			session.write("Error script expression! Please check it again.");
		}
	}
}
