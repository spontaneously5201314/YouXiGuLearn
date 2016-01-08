package com.youxigu.mina.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaTimeServer {
	//2.定义处理类并绑定 NioSocketAcceptor 到一个端口
	private static final int PORT = 9123;
	
	public static void main(String[] args) throws IOException {
		//1.需要一个用于监听连入的连接的对象，因为本程序是基于TCP/IP，所以使用SocketAcceptor
		IoAcceptor acceptor = new NioSocketAcceptor();
		//3.这个过滤器将会用日志记录所有信息，比如 session 的新建、接收到的消息、发送的消息、session 的关闭。
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		//4.这个过滤器将会把二进制或者协议特定的数据翻译为消息对象，反之亦然。
		acceptor.getFilterChain().addLast("codec",
				//使用TextLineCodecFactory因为它将为我们处理基于文本的消息，无须我们自己去编写codec部分
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
		//5.接下来，我们将定义用于侍服客户端连接和当前时间的请求的处理器。处理器类是一个必须实行 IoHandler 接口的类。对于几乎所有的使用 MINA 的程序，这里都会变成程序的重负载的地方，因为它将侍服所有来自客户端的请求。
		acceptor.setHandler(new TimeServerHander());
		//设置IoHandler，为 session 设置了输入缓冲区大小，指定缓冲区大小以通知底层操作系统为传入的数据分配多少空间。
		acceptor.getSessionConfig().setReadBufferSize(2048);
		//设置IoHandler，为 session 设置了idle 属性，指定了什么时候检查空闲 session
		//在对 setIdleTime 的调用中，第一个参数定义了再断定 session 是否闲置时要检查的行为，第二个参数定义了在 session 被视为空闲之前以毫秒为单位的时间长度内必须发生。
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		//  剩下的工作就是定义服务器端将要监听的套接字地址，并进行启动服务的调用。
		acceptor.bind(new InetSocketAddress(PORT));//IoAcceptor.bind()这个方法将会绑定到指定端口并开始处理远程客户端请求。
	}

	
}
                                     