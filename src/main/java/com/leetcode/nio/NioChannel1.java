package com.leetcode.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

/**
 * @Author: wangwu
 * @Date: Created in 16:57 2021/03/05
 * @Description:
 */
public class NioChannel1 {
	public static void main(String[] args) throws Exception {
//		/Users/dfg/workspace/matrix/leetcode-daily-practice/src/main/resources/channel.txt
		RandomAccessFile afile = new RandomAccessFile("/Users/dfg/workspace/matrix/leetcode-daily-practice/src/main/resources/channel.txt","rw");
		FileChannel inChannel = afile.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(100);
		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1){
			System.out.println("Read " + bytesRead);
			buf.flip();
			while(buf.hasRemaining()){
				System.out.print((char) buf.get());
			}
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		afile.close();

	}
}
