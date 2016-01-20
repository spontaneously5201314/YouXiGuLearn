package com.youxigu.se.logger;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * @Description
 * @author Spontaneously
 * @time 2016年1月12日 下午5:50:44
 */
public class MyFormatter extends Formatter {

	@SuppressWarnings("deprecation")
	@Override
	public String format(LogRecord rec) {
		StringBuffer buf = new StringBuffer(1000);
        buf.append(new Date().toLocaleString()); // 时间
        buf.append(" ");
        buf.append(rec.getLevel()); // 消息级别
        buf.append(" ");
        buf.append(rec.getMillis()); // 作为消息ID
        buf.append(" ");
        buf.append(formatMessage(rec));// 格式化日志记录数据
        buf.append(" /n");    //换行
        return buf.toString();
	}

}
