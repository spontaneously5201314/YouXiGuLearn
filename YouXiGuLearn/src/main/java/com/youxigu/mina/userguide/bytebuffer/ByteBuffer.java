package com.youxigu.mina.userguide.bytebuffer;

import java.nio.charset.CharsetEncoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.buffer.IoBufferAllocator;

public class ByteBuffer {

	public static void main(String[] args) {
		IoBuffer buffer = IoBuffer.allocate(16, false);
		buffer.setAutoShrink(true);

		buffer.put((byte) 1);
		System.out.println("Initial Buffer capacity = " + buffer.capacity());
		buffer.shrink();
		System.out.println("Initial Buffer capacity after shrink = " + buffer.capacity());
		buffer.capacity(32);
		System.out.println("Buffer capacity after incrementing capacity to 32 = " + buffer.capacity());
		buffer.capacity(32);
		System.out.println("Buffer capacity after incrementing capacity to 32 = " + buffer.capacity());
		buffer.capacity(64);
		System.out.println("Buffer capacity after incrementing capacity to 32 = " + buffer.capacity());
		buffer.capacity(128);
		System.out.println("Buffer capacity after incrementing capacity to 32 = " + buffer.capacity());
		buffer.shrink();
		System.out.println("Buffer capacity after shrink= " + buffer.capacity());
		buffer.shrink();
		System.out.println("Buffer capacity after shrink= " + buffer.capacity());
		buffer.shrink();
		System.out.println("Buffer capacity after shrink= " + buffer.capacity());

	}
}
