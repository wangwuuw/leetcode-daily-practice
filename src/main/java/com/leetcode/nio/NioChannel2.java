package com.leetcode.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Author: wangwu
 * @Date: Created in 16:38 2021/03/10
 * @Description:
 */
public class NioChannel2 {
	public static void main(String[] args) {
		try{
			RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
			FileChannel fromChannel = fromFile.getChannel();
			RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
			FileChannel      toChannel = toFile.getChannel();
			long position = 0;
			long count = fromChannel.size();
			toChannel.transferFrom(fromChannel,position, count);
		}catch (Exception e){

		}

	}

}
